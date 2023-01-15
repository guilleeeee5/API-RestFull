FROM amazoncorretto:11
COPY target/rest-full-service-0.4.jar rest-full-service-0.4.jar
COPY Covid19-TIA_ZonasBásicasSalud.json Covid19-TIA_ZonasBásicasSalud.json
COPY Covid19-TIA_ZonasBásicasSalud_Mayores60.json Covid19-TIA_ZonasBásicasSalud_Mayores60.json
ENTRYPOINT ["java", "-jar", "/rest-full-service-0.4.jar"]