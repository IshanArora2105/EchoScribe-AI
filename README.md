# 🎙️ Audio to Text Transcriber

A full-stack web application that converts audio files into text using AI-based speech recognition.

---

## 🚀 Features

* Upload audio files (.mp3, .wav, etc.)
* Convert speech → text
* Fast API-based transcription
* Simple UI (React frontend)
* Spring Boot backend

---

## 🛠️ Tech Stack

**Frontend:**

* React (Vite)
* Axios

**Backend:**

* Spring Boot
* REST API

**AI APIs:**

* OpenAI Whisper *(paid)*
* AssemblyAI *(free tier available)*

---

## 📂 Project Structure

```
AudioTranscribe/
│
├── frontend/        # React app
├── backend/         # Spring Boot app
│   ├── controller/
│   ├── config/
│   └── resources/
└── README.md
```

---

## ⚙️ Setup Instructions

### 🔹 1. Clone the repo

```bash
git clone https://github.com/your-username/audio-transcriber.git
cd audio-transcriber
```

---

### 🔹 2. Backend Setup (Spring Boot)

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8081
```

---

### 🔹 3. Frontend Setup

```bash
cd frontend
npm install
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

## 🔑 Environment Variables

### For OpenAI (optional)

```properties
spring.ai.openai.api-key=YOUR_API_KEY
spring.ai.openai.audio.transcription.options.model=whisper-1
```

---

### For AssemblyAI (recommended free)

Replace API key in controller:

```java
String apiKey = "YOUR_ASSEMBLYAI_API_KEY";
```

---

## 📡 API Endpoint

### POST `/api/transcribe`

Upload audio file and get transcription.

### 🔹 Request (Postman / Frontend)

* Method: `POST`
* URL:

```
http://localhost:8081/api/transcribe
```

* Body: `form-data`

  * Key: `file`
  * Type: File
  * Value: upload `.mp3` / `.wav`

---

### 🔹 Response

```json
"Hello, this is your transcribed text."
```

---

## ⚠️ Common Errors

### ❌ 500 Internal Server Error

* Check backend logs
* File format issue
* API failure

---

### ❌ 429 insufficient_quota

* OpenAI billing not enabled
* Solution:

  * Add billing OR
  * Use AssemblyAI

---

## 🔗 Important Links

### 🔹 OpenAI

* API Keys: https://platform.openai.com/api-keys
* Billing: https://platform.openai.com/account/billing
* Docs: https://platform.openai.com/docs

---

### 🔹 AssemblyAI

* Dashboard: https://www.assemblyai.com/dashboard
* API Docs: https://www.assemblyai.com/docs

---

### 🔹 Spring Boot

* Docs: https://spring.io/projects/spring-boot

---

### 🔹 React

* Docs: https://react.dev

---

## 🧠 How It Works

1. User uploads audio file
2. Backend receives file
3. File sent to AI API
4. API processes audio
5. Transcribed text returned to frontend

---

## 📌 Future Improvements

* Upload multiple files
* Real-time transcription
* Language detection
* Save transcription history
* User authentication

---

## 👨‍💻 Author

**Ishan Arora**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!

```
```
