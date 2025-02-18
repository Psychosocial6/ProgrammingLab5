package managers;

import collectionElements.Coordinates;
import collectionElements.FuelType;
import collectionElements.Vehicle;
import commands.Command;
import exceptions.CommandTokenException;
import exceptions.ExecutionException;
import exceptions.WrongDataException;
import utils.Invoker;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleManager {
    private Invoker invoker;

    public ConsoleManager(Invoker invoker) {
        this.invoker = invoker;
    }

    public void readConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] input;
            if (scanner.hasNext()) {
                input = scanner.nextLine().split("\s+");
                String commandToken = input[0];
                if (invoker.getCommands().containsKey(commandToken)) {
                    Object[] args;
                    if (invoker.getCommands().get(commandToken).requiresVehicleObject) {
                        args = new Object[input.length];
                        boolean incorrectData = true;
                        while (incorrectData) {
                            System.out.println("Введите название транспорта (название не может отсутствовать):");
                            String vehicleName;
                            while (true) {
                                vehicleName = scanner.nextLine();
                                if (!vehicleName.isEmpty()) {
                                    break;
                                }
                                else {
                                    System.out.println("Неверное значение поля, введите заново");
                                }
                            }

                            System.out.println("Введите координату x транспортного средства (x <= 232, x - целое число):");
                            Integer x;
                            while (true) {
                                try {
                                    x = scanner.nextInt();
                                    break;
                                }
                                catch (InputMismatchException e) {
                                    System.out.println("Неверное значение поля, введите заново");
                                }
                                finally {
                                    scanner.nextLine();
                                }
                            }


                            System.out.println("Введите координату y транспортного средства (y <= 281, y - целое число):");
                            Long y;
                            while (true) {
                                try {
                                    y = scanner.nextLong();
                                    break;
                                }
                                catch (InputMismatchException e) {
                                    System.out.println("Неверное значение поля, введите заново");
                                }
                                finally {
                                    scanner.nextLine();
                                }
                            }

                            System.out.println("Введите мощность двигателя транспортного средства или пустую строку, если двигатель отсутствует (мощность - целое число > 0)");
                            Long enginePower = null;
                            String pow;
                            while (true) {
                                pow = scanner.nextLine();
                                if (!pow.isEmpty()) {
                                    try {
                                        enginePower = Long.parseLong(pow);
                                        break;
                                    } catch (InputMismatchException | NumberFormatException e) {
                                        System.out.println("Неверное значение поля, введите заново");
                                    }
                                }
                                else {
                                    break;
                                }
                            }

                            System.out.println("Введите вместительность транспортного средства (вместительность - число > 0, необязательно целое):");
                            double capacity;
                            while (true) {
                                try {
                                    capacity = scanner.nextDouble();
                                    break;
                                } catch (InputMismatchException | NumberFormatException e) {
                                    System.out.println("Неверное значение поля, введите заново");
                                }
                                finally {
                                    scanner.nextLine();
                                }
                            }

                            System.out.println("Введите пробег транспортного средства или пустую строку, если пробега нет (пробег - целое число > 0):");
                            Long distanceTravelled = null;
                            String distTr;
                            while (true) {
                                distTr = scanner.nextLine();
                                if (!distTr.isEmpty()) {
                                    try {
                                        distanceTravelled = Long.parseLong(distTr);
                                        break;
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println("Неверное значение поля, введите заново");
                                    }
                                }
                                else {
                                    break;
                                }
                            }

                            System.out.println("Введите тип топлива (ELECTRICITY, DIESEL, MANPOWER, NUCLEAR, ANTIMATTER):");
                            FuelType fuelType;
                            String fuel;
                            while (true) {
                                fuel = scanner.nextLine();
                                try {
                                    fuelType = FuelType.valueOf(fuel);
                                    break;
                                }
                                catch (IllegalArgumentException e) {
                                    System.out.println("Неверное значение поля, введите заново");
                                }
                            }
                            Coordinates coordinates = new Coordinates(x, y);
                            Vehicle vehicle = new Vehicle(vehicleName, coordinates, enginePower, capacity, distanceTravelled, fuelType);
                            try {
                                vehicle.validate();
                                incorrectData = false;
                            } catch (WrongDataException e) {
                                System.out.println(e.getMessage());
                            }
                            for (int i = 1; i < input.length; i++) {
                                args[i - 1] = input[i];
                            }
                            args[args.length - 1] = vehicle;
                        }
                    }
                    else {
                        args = new Object[input.length - 1];
                        for (int i = 1; i < input.length; i++) {
                            args[i - 1] = input[0];
                        }
                    }
                    if (commandToken.equals("help")) {
                        args = new Object[16];
                        int index = 0;
                        for (Command command : invoker.getCommands().values()) {
                            args[index] = command;
                            index++;
                        }

                    }
                    try {
                        invoker.executeCommandUsingToken(commandToken, args);
                    } catch (ExecutionException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (!commandToken.isEmpty()) {
                    throw new CommandTokenException(String.format("Wrong command token, command {%s} doesn't exist", commandToken));
                }
            }
        }
    }
}
