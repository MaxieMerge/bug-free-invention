package com.bug.free.invention.api;
import com.bug.free.invention.api.controllers.DBConfig;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.concurrent.Exchanger;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobControllerTests {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();


    @Before
    public void setup() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        restTemplate.exchange(createURLWithPort("/students"), HttpMethod.POST, entity, String.class);
        //DBConfig.TestMode();
    }



    @Test
    public void CanJobSpecBeEditedValidInputs(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("{\n" +
                "    \"JobSpec\":\"Test Job Input\",\n" +
                "    \"JobID\":23\n" +
                "}", headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/submitJobSpec"),HttpMethod.POST,entity,String.class);
        System.out.println(response);
        String actual = response.getBody();//Objects.requireNonNull(response.getHeaders().get(HttpHeaders.LOCATION)).get(0);
        assertTrue(actual.equals("Submitted"));
    }
    @Test
    public void CanJobSpecBeEditedInValidInputs(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("{\n" +
                "    \"JobSpecss\":\";)--Test Job Input\",\n" +
                "    \"JobIDs\":23\n" +
                "}", headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/submitJobSpec"),HttpMethod.POST,entity,String.class);
        System.out.println(response);
        String actual = response.getBody();//Objects.requireNonNull(response.getHeaders().get(HttpHeaders.LOCATION)).get(0);
        assertTrue(actual.equals("Unsuccessful String submit")||actual.equals("not submitted"));
    }
    @Test
    public void CanJobSpecBeEditedInValidInputsSpecialCharacters(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("{\n" +
                "    \"JobSpec\":\";)--Test Job Input\",\n" +
                "    \"JobID\":23\n" +
                "}", headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/submitJobSpec"),HttpMethod.POST,entity,String.class);
        System.out.println(response);
        String actual = response.getBody();//Objects.requireNonNull(response.getHeaders().get(HttpHeaders.LOCATION)).get(0);
        assertTrue(actual.equals("Invalid String"));
    }
    @Test
    public void DoesJobTableReturnData() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/jobRoles"),HttpMethod.GET,entity,String.class);
        String actual = response.getBody();
        String expected = "[{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Trainee\",\"job_ID\":3,\"job_Title\":\"Trainee AI Engineer\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Trainee\",\"job_ID\":9,\"job_Title\":\"Trainee Data Scientist\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Trainee\",\"job_ID\":42,\"job_Title\":\"Marketing Assistant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Trainee\",\"job_ID\":48,\"job_Title\":\"Martech and Ops Assistant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Trainee\",\"job_ID\":54,\"job_Title\":\"Product Consultant\u200B\u200B\u200B\u200B\u200B\u200B\u200B\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Trainee\",\"job_ID\":61,\"job_Title\":\"Specialist Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Associate\",\"job_ID\":4,\"job_Title\":\"Associate AI Engineer\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Definesdfsdsdf\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Associate\",\"job_ID\":10,\"job_Title\":\"Associate Data Scientist\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Defineyjhtyjhytj\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Associate\",\"job_ID\":18,\"job_Title\":\"Business Development Associate\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Associate\",\"job_ID\":23,\"job_Title\":\"Customer Success Associate\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Test Job Input\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Associate\",\"job_ID\":37,\"job_Title\":\"Sales Development Representative\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Associate\",\"job_ID\":43,\"job_Title\":\"Marketing Associate\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Associate\",\"job_ID\":49,\"job_Title\":\"Martech and Ops Associate\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Associate\",\"job_ID\":55,\"job_Title\":\"Product Consultant\u200B\u200B\u200B\u200B\u200B\u200B\u200B\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Associate\",\"job_ID\":62,\"job_Title\":\"Specialist Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Senior\",\"job_ID\":5,\"job_Title\":\"Senior AI Engineer\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Senior\",\"job_ID\":11,\"job_Title\":\"Senior Data Scientist\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Senior\",\"job_ID\":19,\"job_Title\":\"Senior Business Development Associate\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Senior\",\"job_ID\":24,\"job_Title\":\"Customer Success Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Senior\",\"job_ID\":32,\"job_Title\":\"Senior Bid Production Associate\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Senior\",\"job_ID\":38,\"job_Title\":\"Senior Sales Development Representative\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Senior\",\"job_ID\":44,\"job_Title\":\"Marketing Executive\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Senior\",\"job_ID\":50,\"job_Title\":\"Martech and Ops Executive\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Senior\",\"job_ID\":56,\"job_Title\":\"Product Consultant\u200B\u200B\u200B\u200B\u200B\u200B\u200B\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Senior\",\"job_ID\":63,\"job_Title\":\"Specialist Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Consultant\",\"job_ID\":6,\"job_Title\":\"Lead AI Engineer\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Consultant\",\"job_ID\":12,\"job_Title\":\"Consultant Data Scientist\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":20,\"job_Title\":\"Business Development Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":25,\"job_Title\":\"Customer Success Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":28,\"job_Title\":\"Cloud Partner Operations Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":29,\"job_Title\":\"Partners Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":33,\"job_Title\":\"Technical Pre-Sales Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":34,\"job_Title\":\"Bid Production Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":39,\"job_Title\":\"Sales Development \u200B\u200B\u200B\u200B\u200B\u200B\u200BConsultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":45,\"job_Title\":\"Senior Marketing Executive\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Consultant\",\"job_ID\":51,\"job_Title\":\"Senior Martech and Ops Executive\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Consultant\",\"job_ID\":57,\"job_Title\":\"Product Consultant\u200B\u200B\u200B\u200B\u200B\u200B\u200B\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Consultant\",\"job_ID\":64,\"job_Title\":\"Specialist Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Manager\",\"job_ID\":7,\"job_Title\":\"AI Engineering Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Manager\",\"job_ID\":13,\"job_Title\":\"Data Science Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":21,\"job_Title\":\"Business Development Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":26,\"job_Title\":\"Customer Success Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":30,\"job_Title\":\"Partners Relationship Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":35,\"job_Title\":\"Bid Production Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":40,\"job_Title\":\"Sales Development Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":46,\"job_Title\":\"Marketing Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Manager\",\"job_ID\":52,\"job_Title\":\"Digital Strategy Manager\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Manager\",\"job_ID\":58,\"job_Title\":\"Product Consultant\u200B\u200B\u200B\u200B\u200B\u200B\u200B\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Manager\",\"job_ID\":59,\"job_Title\":\"Digital Advisory Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Principal\",\"job_ID\":8,\"job_Title\":\"Principal AI Engineer\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Artificial Intelligence\",\"capability_Name\":\"Principal\",\"job_ID\":14,\"job_Title\":\"Prinicple Data Scientist\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":22,\"job_Title\":\"Business Development Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"dsfdssdf\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":27,\"job_Title\":\"Customer Success Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":31,\"job_Title\":\"Partners Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":36,\"job_Title\":\"Bid Production Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":41,\"job_Title\":\"Product Demand Generation Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":47,\"job_Title\":\"Marketing Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Principal\",\"job_ID\":53,\"job_Title\":\"Digital Strategy Director\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Principal\",\"job_ID\":60,\"job_Title\":\"Digital Advisory Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Principal\",\"job_ID\":65,\"job_Title\":\"Product Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Principal\",\"job_ID\":65,\"job_Title\":\"Product Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Product\",\"capability_Name\":\"Principal\",\"job_ID\":65,\"job_Title\":\"Product Consultant\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Leadership Community\",\"job_ID\":15,\"job_Title\":\"Global Head of Marketing\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Leadership Community\",\"job_ID\":16,\"job_Title\":\"Businsess Lead Development\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"},{\"band_Name\":\"Business Development and Marketing\",\"capability_Name\":\"Leadership Community\",\"job_ID\":17,\"job_Title\":\"Account Lead\",\"job_Spec\":null,\"band_ID\":0,\"capability_ID\":0,\"spec_Summary\":\"Please Define\"}]";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    @Test
    public void DoesJobLinkReturnValidInput(){
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/jobSpec?JobID=2"),HttpMethod.GET,entity,String.class);
        String actual = response.getBody();
        assertTrue(actual.contains("https://kainossoftwareltd.sharepoint.com/"));

    }
    @Test
    public void DoesJobLinkReturnWhenValueIsGreaterThanTable(){
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/jobSpec?JobID=9999999"),HttpMethod.GET,entity,String.class);
        String actual = response.getBody();
        System.out.println(actual);
        assertTrue(actual.equals("https://www.google.com"));

    }
    @Test
    public void DoesJobLinkRejectOnIncorrectData(){
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/jobs/jobSpec?JobID=Hellooo"),HttpMethod.GET,entity,String.class);
        int actual = response.getStatusCodeValue();
        assertTrue(actual ==400);

    }

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;
    }
}
