package com.raduq.service;

import com.raduq.MarsTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by raduq on 18/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MarsTestRunner.class)
public class NavigationServiceTest {

    @Autowired
    NavigationService service;

    @Test
    public void canNavigate_M() throws Exception {
        Assert.assertEquals("0,1,N",service.navigate("M"));
    }

    @Test
    public void canNavigateLowercase_m() throws Exception {
        Assert.assertEquals("0,1,N",service.navigate("m"));
    }

    @Test
    public void canTurnLeft_L() throws Exception {
        Assert.assertEquals("0,0,W",service.navigate("L"));
    }

    @Test
    public void canTurnRight_R() throws Exception {
        Assert.assertEquals("0,0,E",service.navigate("R"));
    }

    @Test
    public void canTurnLeftTwice_LL() throws Exception {
        Assert.assertEquals("0,0,S",service.navigate("LL"));
    }

    @Test
    public void canTurnRightTwice_RR() throws Exception {
        Assert.assertEquals("0,0,S",service.navigate("RR"));
    }

    @Test
    public void canNavigateTwice_MML_MML() throws Exception {
        String response1 = service.navigate("MML");
        String response2 = service.navigate("MML");
        Assert.assertEquals("0,2,W",response1);
        Assert.assertEquals("0,2,W",response2);
    }

    @Test(expected = RuntimeException.class)
    public void cantNavigateOutOfBounds_LM() throws Exception {
        service.navigate("LM");
    }

    @Test(expected = RuntimeException.class)
    public void cantNavigateInvalidCommand_AAA() throws Exception {
        service.navigate("AAA");
    }
}
