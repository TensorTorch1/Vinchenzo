package frc.robot.containers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.components.hardware.VictorSPComponent;
import frc.robot.subsystems.TankDrive.TankDrive;

public class NewRobotContainer implements RobotContainer {
    private Joystick driveStick = new Joystick(0), controlStick = new Joystick(1);
    private VictorSPComponent sp = new VictorSPComponent(0);
    private VictorSPComponent sp2 = new VictorSPComponent(1);
    private VictorSPComponent sp3 = new VictorSPComponent(2);
    private VictorSPComponent sp4 = new VictorSPComponent(3);
    public TankDrive leftTankDrive = new TankDrive(sp, sp2);
    public TankDrive rightTankDrive = new TankDrive(sp3, sp4);
    private double xSensitivity = 4, ySensitivity = 4, zSensitivity = 4, xDeadzone = 0.2, yDeadzone = 0.2, zDeadzone = 0.3;

    public NewRobotContainer() { 
        configureTankDrive();

    }

    public void configureTankDrive() {
        
    }
}
