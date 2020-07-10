package api.usersApi.response;

import lombok.Data;

@Data
public class UserPostResponse {

    private String name;
    private String job;
    private String id;
    private String createdAt;

}
