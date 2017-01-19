package com.raduq.service;

import com.raduq.objects.Planet;
import com.raduq.objects.Robot;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raduq on 19/01/17.
 */
public class InstructionTest {

    @Test
    public void canNavigate_M() throws Exception {
        Assert.assertEquals("0,1,N",new Instruction("M").execute(new Robot(),new Planet()).get().location());
    }

    @Test
    public void canNavigateLowercase_m() throws Exception {
        Assert.assertEquals("0,1,N",new Instruction("m").execute(new Robot(),new Planet()).get().location());
    }

    @Test
    public void canTurnLeft_L() throws Exception {
        Assert.assertEquals("0,0,W",new Instruction("L").execute(new Robot(),new Planet()).get().location());
    }

    @Test
    public void canTurnRight_R() throws Exception {
        Assert.assertEquals("0,0,E",new Instruction("R").execute(new Robot(),new Planet()).get().location());
    }

    @Test
    public void canTurnLeftTwice_LL() throws Exception {
        Assert.assertEquals("0,0,S",new Instruction("LL").execute(new Robot(),new Planet()).get().location());
    }

    @Test
    public void canTurnRightTwice_RR() throws Exception {
        Assert.assertEquals("0,0,S",new Instruction("RR").execute(new Robot(),new Planet()).get().location());
    }

    @Test
    public void canNavigateTwice_MML_MML() throws Exception {
        String response1 = new Instruction("MML").execute(new Robot(),new Planet()).get().location();
        String response2 = new Instruction("MML").execute(new Robot(),new Planet()).get().location();
        Assert.assertEquals("0,2,W",response1);
        Assert.assertEquals("0,2,W",response2);
    }

    @Test(expected = RuntimeException.class)
    public void cantNavigateOutOfBounds_LM() throws Exception {
        new Instruction("LM").execute(new Robot(),new Planet());
    }

    @Test(expected = RuntimeException.class)
    public void cantNavigateInvalidCommand_AAA() throws Exception {
        new Instruction("AAA").execute(new Robot(),new Planet());
    }
}
