package frc.robot.subsystems.TankDrive;

import frc.robot.components.hardware.VictorSPComponent;
import frc.robot.components.hardware.DoubleOutputSetterComponent;
public class TankDriveFactory {
    public static TankDrive makeTankDrive() {
        VictorSPComponent left1 = new VictorSPComponent(0);
        VictorSPComponent left2 = new VictorSPComponent(1);
        VictorSPComponent right1 = new VictorSPComponent(2);
        VictorSPComponent right2 = new VictorSPComponent(3);
        DoubleOutputSetterComponent left = new DoubleOutputSetterComponent(left1, left2);
        DoubleOutputSetterComponent right = new DoubleOutputSetterComponent(right1, right2);
        TankDrive tankDrive = new TankDrive(left, right);
        return tankDrive;
    }
}
