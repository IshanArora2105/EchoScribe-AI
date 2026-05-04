package com.audio.transcribe;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/transcribe")
public class TranscriptionController {

    private final OpenAiAudioTranscriptionModel transcriptionModel;


    public TranscriptionController(OpenAiAudioTranscriptionModel transcriptionModel) {
        this.transcriptionModel = transcriptionModel;
    }

    @PostMapping
    public ResponseEntity<String> transcribeAudio(
            @RequestParam("file") MultipartFile file) {

        File tempFile = null;

        try {
            
            String originalName = file.getOriginalFilename();

            String extension = (originalName != null && originalName.contains("."))
                    ? originalName.substring(originalName.lastIndexOf("."))
                    : ".mp3";

            tempFile = File.createTempFile("audio_", extension);
            file.transferTo(tempFile);

            System.out.println("File received: " + originalName);
            System.out.println("Temp path: " + tempFile.getAbsolutePath());
            System.out.println("File size: " + tempFile.length());

          
            OpenAiAudioTranscriptionOptions options =
                    OpenAiAudioTranscriptionOptions.builder()
                            .language("en")
                            .temperature(0f)
                            .build();

           
            FileSystemResource audioFile = new FileSystemResource(tempFile);

            AudioTranscriptionPrompt request =
                    new AudioTranscriptionPrompt(audioFile, options);

            
            AudioTranscriptionResponse response = transcriptionModel.call(request);

            String result = response.getResult().getOutput();

            System.out.println("Transcription: " + result);

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            e.printStackTrace(); 
            return ResponseEntity.status(500)
                    .body("Error: " + e.getMessage());
        } finally {
            
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }
}

