// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.TankDrive;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.Subsystem;
=======
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.command.SubsystemBase;

>>>>>>> 61412c43e49b3998a3d318ca9d6d8e715c364789
import frc.robot.components.OutputSetterComponent;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;


public class TankDrive extends Subsystem {
	private OutputSetterComponent left;
	private OutputSetterComponent right;
	private DifferentialDriveKinematics driveKinematic;
	private double maxWheelSpeed = 10d;
	/** Creates a new TankDrive. */
    public TankDrive(OutputSetterComponent left, OutputSetterComponent right) {
    	this.left = left;
    	this.right = right;
    	this.driveKinematic = new DifferentialDriveKinematics(0.8);
    }

	public void move(double x, double w) {
		ChassisSpeeds speeds = new ChassisSpeeds(x, 0, w);
<<<<<<< HEAD
		DifferentialDriveWheelSpeeds speedsTwo = asdf.toWheelSpeeds(speeds);
		speedsTwo.normalize(maxWheelSpeed);
=======
		DifferentialDriveWheelSpeeds speedsTwo = driveKinematic.toWheelSpeeds(speeds);
		speedsTwo.desaturate(maxWheelSpeed);
>>>>>>> 61412c43e49b3998a3d318ca9d6d8e715c364789
		left.setOutput(speedsTwo.leftMetersPerSecond);
		right.setOutput(speedsTwo.rightMetersPerSecond);
	}

	@Override
	public void periodic() {
    	// This method will be called once per scheduler run
	}

	@Override
	public void initDefaultCommand() {
		//idk
	}
}
