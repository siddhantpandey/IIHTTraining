package com.verizon.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestScoringServiceGetPercentage.class, TetsScoringServiceGetGrade.class })
public class ScoreSuite {

}
