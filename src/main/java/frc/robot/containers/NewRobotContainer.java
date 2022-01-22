package frc.robot.containers;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.subsystems.TankDrive.TankDrive;
import frc.robot.subsystems.TankDrive.TankDriveFactory;
import frc.robot.subsystems.TankDrive.TankDriveCommand;
import frc.robot.subsystems.shooter.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import java.util.Map;

public class NewRobotContainer implements RobotContainer {
    private Joystick driveStick = new Joystick(0);
    private TankDrive tankDrive = TankDriveFactory.makeTankDrive();
    private double xSensitivity = -1, ySensitivity = 1, zSensitivity = 4, xDeadzone = 0.2, yDeadzone = 0.2, zDeadzone = 0.3;
    private Shooter shooter;
    private ShooterControl shooterControl;
    private JoystickButton shooterButton = new JoystickButton(driveStick, 2);
    private NetworkTableEntry shooterSpeed;




    public NewRobotContainer() { 
        
        configureTankDrive();

    }

    public void configureTankDrive() {
        TankDriveCommand tankCommand = new TankDriveCommand(tankDrive, driveStick, xDeadzone, xSensitivity);
        tankDrive.setDefaultCommand(tankCommand);
        
    }

    public void configureShooter() {
        shooter = HardwareShooterFactory.makeShooter();
        shooterButton.whenPressed(new ShooterSpinUpCommand(shooter, shooterControl));
        shooterButton.whenReleased(new ShooterSpinDownCommand(shooter));
        shooterSpeed = Shuffleboard.getTab("shooter")
        .add("Speed", 0).getEntry();
        
    }

    public void teleopPeriodic() {
        shooterControl.shooterSpeed = shooterSpeed.getDouble(shooterControl.shooterSpeed);
        shooterSpeed.setDouble(shooterControl.shooterSpeed);
    }
}
