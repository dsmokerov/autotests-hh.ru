package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyListResponseModel {
    private VacancyItem[] items;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VacancyItem {
        private String id;
        private boolean premium;
        private String name;
        private String department;
        private boolean hasTest;
        private boolean responseLetterRequired;
        private Area area;
        private Salary salary;
        private Type type;

        @Data
        @NoArgsConstructor
        public static class Area {
            private String id;
            private String name;
            private String url;
        }

        @Data
        @NoArgsConstructor
        public static class Salary {
            private Integer from;
            private Integer to;
            private String currency;
            private boolean gross;
        }

        @Data
        @NoArgsConstructor
        public static class Type {
            private String id;
            private String name;
        }
    }
}