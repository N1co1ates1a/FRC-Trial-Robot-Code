// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final PWMVictorSPX right_1 = new PWMVictorSPX(1);
  private final PWMVictorSPX left_1 = new PWMVictorSPX(2);
  private final PWMVictorSPX right_2 = new PWMVictorSPX(3);
  private final PWMVictorSPX left_2 = new PWMVictorSPX(4);

  private final SpeedControllerGroup right = new SpeedControllerGroup(right_1, right_2);
  private final SpeedControllerGroup left = new SpeedControllerGroup(left_1, left_2);

  private final DifferentialDrive robot = new DifferentialDrive(left, right);

  private final PWMVictorSPX el1 = new PWMVictorSPX(1);
  private final PWMVictorSPX el2 = new PWMVictorSPX(2);

  private final SpeedControllerGroup elevator = new SpeedControllerGroup(el1, el2);

  private final Joystick xbox = new Joystick(1);

  private final JoystickButton elup = new JoystickButton(xbox, 1);
  private final JoystickButton eldown = new JoystickButton(xbox, 2);

  private final Timer tiktak = new Timer();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    
  }


  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putString("Robot Initiliazed", "True");
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    SmartDashboard.putString("Autonomous", "Running...");
    //While(true)
    
    
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
 
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    robot.tankDrive(0.5, 0.5);
 
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    SmartDashboard.putString("Teleop", "Running...");
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    robot.tankDrive(xbox.getRawAxis(1), xbox.getRawAxis(3));

    left.set(xbox.getRawAxis(1);
    right.set(xbox.getRawAxis(3); 

    elup.set(xbox.getRawButton(1));
    eldown.set(xbox.getRawButton(0));
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    SmartDashboard.putString("Test", "Running...");
    tiktak.reset();
    tiktak.start();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    if(tiktak.get() <= (double)135) {
    robot.tankDrive(xbox.getRawAxis(1), xbox.getRawAxis(3));

    left.set(xbox.getRawAxis(1);
    right.set(xbox.getRawAxis(3); 

    elup.set(xbox.getRawButton(1));
    eldown.set(xbox.getRawButton(0));
    }//if sonu

  }//test periyot sonu

}
