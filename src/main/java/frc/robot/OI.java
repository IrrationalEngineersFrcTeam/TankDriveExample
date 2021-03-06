/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchHoldOpenCommand;
import frc.robot.commandGroups.PlaceHatchLevel_1;
import frc.robot.commandGroups.PlaceHatchLevel_2;
import frc.robot.commandGroups.PlaceHatchLevel_3;
import frc.robot.commandGroups.RetractAllHatchElements;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.ArmRetractCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.SlideElevatorForwardCommand;
import frc.robot.commands.SlideElevatorBackCommand;

public class OI {
  //This creates any joysticks we will use to drive the robot,
  //in this case a left joystick and a right joystick.
  public Joystick StickL;
  public Joystick StickR;

  //Here we have the hatch mechanism buttons
  public Button HatchHoldOpenButton;

  //These Arm and slider buttons are for testing and will probably be removed
  public Button ArmExtendButton;
  public Button ArmRetractButton;

  //These buttons are to slide the elevator forward and back
  public Button SliderForward;
  public Button SliderBack;

  //These Buttons are for the command groups for lifting the hatch to specific levels
  public Button PlaceHatchLevel_1_Button;
  public Button PlaceHatchLevel_2_Button;
  public Button PlaceHatchLevel_3_Button;
  public Button RetractAllHatchElements;

  //These are the manual elevator control buttons
  public Button ElevatorUp;
  public Button ElevatorDown;

  //Arcade drive button
  public Button ArcadeMode;


  /*
  
    This is a list of all the buttons that are being used and what commands they go to:
      StickL (Left joystick):
        1 ------------------ ArcadeMode
        2 ------------------ ArmRectractCommand
        3 ------------------ ArmExtendCommand
        4 ------------------ RetractAllHatchElements
        11 ----------------- SlideElevatorForwardCommand
        16 ----------------- SlideElevatorBackCommand
    
      StickR(Right joystick):
        1 ------------------- HoldHatchOpenCommand
        2 ------------------- PlaceHatchLevel_1
        3 ------------------- PlaceHatchLevel_2
        4 ------------------- PlaceHatchLevel_3
        5 ------------------- ElevatorUpCommand
        10 ------------------ ElevatorDownCommand
      
  
  */

  public OI() {
    //This tells the robot what ports these joysticks will be connected to, 

    StickL = new Joystick(0);
    StickR = new Joystick(1);

    //This is where we tie the code buttons to the buttons on the joysticks
    //In this case the hatch button
    HatchHoldOpenButton = new JoystickButton(StickR, 1);
    
    //These buttons are for testing purposes, they will be phased out in the future
    ArmExtendButton = new JoystickButton(StickL, 3);
    ArmRetractButton = new JoystickButton(StickL, 2);

    //These are for the slider piston for the elevator
    SliderForward = new JoystickButton(StickL, 11);
    SliderBack = new JoystickButton(StickL, 16);

  	//These buttons are the buttons for the command groups, eventually we will only have these buttons
  	//instead of seperate buttons for the ArmExtend/Retract and the elevator buttons
  	//We will change the button ports later
    PlaceHatchLevel_1_Button = new JoystickButton(StickR, 2);
    PlaceHatchLevel_2_Button = new JoystickButton(StickR, 3);
    PlaceHatchLevel_3_Button = new JoystickButton(StickR, 4);
    RetractAllHatchElements = new JoystickButton(StickL, 4);

    //Spool should be wound on the left
    ElevatorDown = new JoystickButton(StickR, 10);
    ElevatorUp = new JoystickButton(StickR, 5);

    //Arcade drive Button
    ArcadeMode = new JoystickButton(StickL, 1);

    //Hatch hold command
    HatchHoldOpenButton.whileHeld(new HatchHoldOpenCommand());

    //These are temporary
    ArmExtendButton.whenPressed(new ArmExtendCommand());
    ArmRetractButton.whenPressed(new ArmRetractCommand());

    //The slider command
    SliderForward.whenPressed(new SlideElevatorForwardCommand());
    SliderBack.whenPressed(new SlideElevatorBackCommand());

    //The Place Hatch commands
    PlaceHatchLevel_1_Button.whenPressed(new PlaceHatchLevel_1());
    PlaceHatchLevel_2_Button.whenPressed(new PlaceHatchLevel_2());
    PlaceHatchLevel_3_Button.whenPressed(new PlaceHatchLevel_3());
    RetractAllHatchElements.whenPressed(new RetractAllHatchElements());

    //Elevator commands
    ElevatorUp.whileHeld(new ElevatorUpCommand());
    ElevatorDown.whileHeld(new ElevatorDownCommand());

  }
}
