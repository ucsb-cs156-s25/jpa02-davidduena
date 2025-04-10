package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_sameObject() {
        Team team = new Team("Team15");
        team.addMember("m1");
        team.addMember("m2");

        assert(team.equals(team)); // Same object
    }

    @Test
    public void test_differentClass() {
        Team team = new Team("Team15");
        team.addMember("m1");
        team.addMember("m2");

        String notATeam = "Not a team";
        assert(!(team.equals(notATeam))); // Not a Team instance
    }

    @Test
    public void test_SameNameAndMembers() {
        Team team1 = new Team("Team15");
        team1.addMember("m1");
        team1.addMember("m2");

        Team team2 = new Team("Team15");
        team2.addMember("m1");
        team2.addMember("m2");

        assert(team1.equals(team2)); // Name and members match
    }

    @Test
    public void test_SameNameDifferentMembers() {
        Team team1 = new Team("Team15");
        team1.addMember("m1");
        team1.addMember("m2");

        Team team2 = new Team("Team15");
        team2.addMember("m3");
        team2.addMember("m4");

        assert(!(team1.equals(team2))); // Same name, different members
    }

    @Test
    public void test_DifferentNameSameMembers() {
        Team team1 = new Team("Team15");
        team1.addMember("m1");
        team1.addMember("m2");

        Team team2 = new Team("Team0");
        team2.addMember("m1");
        team2.addMember("m2");

        assert(!(team1.equals(team2))); // Different name, same members
    }

    @Test
    public void test_DifferentNameAndMembers() {
        Team team1 = new Team("Team15");
        
        team1.addMember("m1");
        team1.addMember("m2");

        Team team2 = new Team("Team0");
        
        team2.addMember("m3");
        team2.addMember("m4");

        assert(!(team1.equals(team2))); // Different name, different members
    }
    @Test
    public void test_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test void test_equivHash() {
        Team t1 = new Team();
        int result = t1.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
