package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class Consola extends LecturaAccion{

    private static Consola consola;

    private Consola() {
    }

    public static Consola getInstance() {
        if (consola==null) {
            consola = new Consola();
        }
        return consola;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("::::: BIENVENIDO :::::");
        System.out.println("Seleccione el tipo de cuenta");
        System.out.println("1.- PACIENTE");
        System.out.println("2.- MÉDICO");
        System.out.println("3.- SALIR");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 3;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;

        boolean cgd = true;
        while (cgd) {
            switch (opcion) {
                case 1:
                    //Registro del paciente
                    ejecutable = RegistroPaciente.getInstance();
                    if (ejecutable != null) {
                        ejecutable.setFlag(true);
                        ejecutable.run();
                        // Al terminar RegistroPaciente, ejecuta RegistroDirPac automáticamente
                        Ejecutable siguiente1 = RegistroDirPac.getInstance();
                        siguiente1.setFlag(true);
                        siguiente1.run();
                        cgd = false;
                        // Al terminar RegistroDirPac, ejecuta DatosMedicosPac automáticamente
                        Ejecutable siguiente2 = DatosMedicosPac.getInstance();
                        siguiente2.setFlag(true);
                        siguiente2.run();
                        cgd = false;
                        // Al terminar DatosMedicosPac, ejecuta ClinicasCatalogo automáticamente
                        System.out.println("1.- Ver Lista de Clínicas");
                        System.out.println("2.- Salir");
                        int opl = ReadUtil.readInt();
                        if (opl == 1) {
                            Ejecutable siguiente3 = ClinicasCatalogo.getInstance();
                            siguiente3.setFlag(true);
                            siguiente3.run();
                            cgd = false;
                        }
                        else {
                            return;
                        }
                    }
                case 2:
                    System.out.println("Por implementar");
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }


        if (ejecutable != null) {
            ejecutable.setFlag(true);
            ejecutable.run();
        }
    }
}
