package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployersListResponseModel {
   private EmployerItem[] items;

   @Data
   @JsonIgnoreProperties(ignoreUnknown = true)
   public static class EmployerItem {
      private String id;
      private String name;
      private String url;
      private String alternate_url;
      private LogoUrls logo_urls;
      private String vacancies_url;
      private int open_vacancies;

      @Data
      @JsonIgnoreProperties(ignoreUnknown = true)
      public static class LogoUrls {
         private String original;
         private String _240;
         private String _90;
      }
   }
}