package com.raduq.service;

import com.raduq.MarsTestRunner;
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
    public void canNavigate() throws Exception {

    }
}
