/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClimbModeCommand extends Command {

  static boolean climbModeBool = Robot.oi.climbModeButton.get();
  public static double DriveConstant;

  public ClimbModeCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climbmodesub);
  
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {

    if(climbModeBool == true)
    {
    DriveConstant = Robot.climbmodesub.Boost();
    }
    else
    {
    DriveConstant = Robot.climbmodesub.unBoost();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return climbModeBool;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climbmodesub.unBoost();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climbmodesub.unBoost();
    end();
     
  }
}
