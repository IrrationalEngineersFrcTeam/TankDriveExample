/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;


public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ElevatorSpeed(double ElevSpeed) 
  {

    Robot.robotmap.MotorElevControl.set(ElevSpeed);
    
  }

  public boolean LimitSwitchHigh()
  {
    System.out.println("High limit switch triggered");
    return Robot.limitHighTriggered;
  }

  public boolean LimitSwitchLow()
  {
    System.out.println("Low limit switch triggered");
    return Robot.limitLowTriggered;
  }

  public void ElevatorUp() {
    Robot.robotmap.MotorElevControl.set(1);
    System.out.println("Going UP!");
  }

  public void ElevatorDown() {
    Robot.robotmap.MotorElevControl.set(-1);
    System.out.println("Going DOWN!");
  }

  public void ElevatorStop() {
    Robot.robotmap.MotorElevControl.set(0);
  }

}
