package com.epam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
  as we are overriding the guardian separately
  so wee need to map it correctly
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides(
        {
                @AttributeOverride(name = "name",column = @Column(name = "guardian_name")),
                @AttributeOverride(name = "emailId",column = @Column(name = "guardian_email_id")),
                @AttributeOverride(name = "phone", column = @Column(name = "guardian_phone"))
        }
)
public class Guardian {

    private String name;
    private String emailId;
    private String phone;

}
