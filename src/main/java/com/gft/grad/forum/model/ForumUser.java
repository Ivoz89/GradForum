/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.persistence.Version;
import lombok.Data;

/**
 *
 * @author izielinski
 */
@Entity
@Data
public class ForumUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] avatar;

    @Version
    private Long version = 0L;

    @Column(unique = true)
    private String username;

    private String password;
    private String role;

    public String getAvatarString() {
        if (avatar != null) {
            return new String(avatar);
        } else {
            return null;
        }
    }
}
