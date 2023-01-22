// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Imports for using the CANSparkMax
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// Imports for the rest of the drive train
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class DriveTrain extends SubsystemBase {

    private CANSparkMax RightFrontMotor;
    private CANSparkMax RightBackMotor;
    private CANSparkMax LeftFrontMotor;
    private CANSparkMax LeftBackMotor;
    private MotorControllerGroup rightMotorGroup;
    private MotorControllerGroup leftMotorGroup;
    private static final int frontleftDeviceID = 3; 
    private static final int backleftDeviceID = 4; 
    private static final int frontrightDeviceID = 1; 
    private static final int backrightDeviceID = 2; 
    private DifferentialDrive drive;

    public DriveTrain() {
        // Code created by Kona

        // RIGHT MOTORS
        // Creation of Right Motors and grouping them into a motor group
        RightFrontMotor = new CANSparkMax(frontrightDeviceID, MotorType.kBrushed);
        RightBackMotor = new CANSparkMax(backrightDeviceID, MotorType.kBrushed);
        rightMotorGroup = new MotorControllerGroup(RightFrontMotor, RightBackMotor);
        addChild("RightMotorGroup",rightMotorGroup);

        // Left Motors
        // Creation of LEFT Motors and grouping them into a motor group
        LeftFrontMotor = new CANSparkMax(frontleftDeviceID, MotorType.kBrushed);
        LeftBackMotor = new CANSparkMax(backleftDeviceID, MotorType.kBrushed);
        leftMotorGroup = new MotorControllerGroup(LeftFrontMotor, LeftBackMotor);
        addChild("LeftMotorGroup",leftMotorGroup);

        // Creation of differential drive using the left adn right motorgroup
        drive = new DifferentialDrive(rightMotorGroup, leftMotorGroup);
        addChild("Drive",drive);
        drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setMaxOutput(1.0);

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double left, double right) {

        drive.tankDrive(left, right);
        //System.out.println("left " + left);
        //System.out.println("right " + right);
    }

}

