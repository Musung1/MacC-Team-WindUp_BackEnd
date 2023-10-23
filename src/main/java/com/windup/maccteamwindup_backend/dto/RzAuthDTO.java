package com.windup.maccteamwindup_backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RzAuthDTO {
    private String access_token;
    private long expire_at;
}
