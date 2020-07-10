package api.usersApi.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SingleUserResponse {

    private Data data;
    private Ad ad;

    @Getter
    @Setter
    class Data{
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Getter
    @Setter
    class Ad{
        private String company;
        private String url;
        private String text;
    }
}
