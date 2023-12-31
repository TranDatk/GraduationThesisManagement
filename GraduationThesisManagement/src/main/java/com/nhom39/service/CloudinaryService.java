package com.nhom39.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    public String uploadAvatar(MultipartFile file);
    public String uploadAvatar(String fileUrl);
    public String uploadFile(MultipartFile file, String fileName);
}
