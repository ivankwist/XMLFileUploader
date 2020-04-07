package com.example.XMLFileUploader;

public class UploadResponse {
    private final String filename;
    private final String timestamp;
    private final long size;

    public UploadResponse(String filename, String timestamp, long size) {
        this.filename = filename;
        this.timestamp = timestamp;
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public long getSize() {
        return size;
    }
}
