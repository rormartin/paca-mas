/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.urjc.ia.paca.agents;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.servlet.http.HttpServletRequest;

import es.urjc.ia.paca.ontology.Caso;
import es.urjc.ia.paca.ontology.FicheroAlumno;
import es.urjc.ia.paca.ontology.FicheroIN;
import es.urjc.ia.paca.ontology.FicheroOUT;
import es.urjc.ia.paca.ontology.FicheroPropio;
import es.urjc.ia.paca.ontology.Practica;
import es.urjc.ia.paca.ontology.Test;
import es.urjc.ia.paca.util.Testigo;
import java.util.StringTokenizer;

/**
 *
 * @author alvaro
 */
public class InterfazJSPGestor extends InterfazGestor {

    public class AutenticaRequestBeha extends OneShotBehaviour {

        private Testigo test2;

        public AutenticaRequestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.test2 = tes1;
        }

        public void action() {
            HttpServletRequest param1 = (HttpServletRequest) test2.getParametro();
            String auxUsuario = param1.getParameter("user_id");
            String auxPass = param1.getParameter("password");
            addBehaviour(new EnviaAutenticaBehaviour(this.myAgent, test2, auxUsuario, auxPass));
        }
    }

    /***********COMPORTAMIENTOS PARA PEDIR ***************************/
    public class PideTestRequestBeha extends OneShotBehaviour {

        private Testigo tes2;

        public PideTestRequestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombrePractica");
            Practica practica = null;
            if (nombre != null) {
                String descripcion = request.getParameter("DescripcionPractica");
                String fechaEntrega = request.getParameter("FechaPractica");
                practica = new Practica(nombre, descripcion, fechaEntrega);
            }
            addBehaviour(new PideTestBeha(this.myAgent, tes2, practica, true));
        }
    }

    public class SeleccionarTestBeha extends OneShotBehaviour {

        private Testigo tes2;

        public SeleccionarTestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String nombre = (String) tes2.getParametro();
            Practica practica = new Practica(nombre);

            addBehaviour(new PideTestBeha(this.myAgent, tes2, practica, false));
        }
    }

    public class PideFicherosPropiosBeha extends OneShotBehaviour {

        private Testigo tes2;

        public PideFicherosPropiosBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            Test test = null;
            String nombre = request.getParameter("NombreTest");
            if (nombre != null) {
                String descripcion = request.getParameter("DescripcionTest");
                String ejecutable = request.getParameter("EjecutableTest");
                if (ejecutable != null){
                    test = new Test(nombre, descripcion, ejecutable);
                }
                else{
                test = new Test(nombre, descripcion);
                }
            }
            addBehaviour(new PideFicherosPropios(this.myAgent, tes2, test, true));
        }
    }

    public class SeleccionarFicherosPropiosBeha extends OneShotBehaviour {

        private Testigo tes2;

        public SeleccionarFicherosPropiosBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            Test test = (Test) tes2.getParametro();

            addBehaviour(new PideFicherosPropios(this.myAgent, tes2, test, false));
        }
    }

    public class PideFicherosAlumnoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public PideFicherosAlumnoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            Test test = null;
            String nombre = request.getParameter("NombreTest");
            if (nombre != null) {
                String descripcion = request.getParameter("DescripcionTest");
                String ejecutable = request.getParameter("EjecutableTest");
                if (ejecutable != null){
                    test = new Test(nombre, descripcion, ejecutable);
                }
                else{
                test = new Test(nombre, descripcion);
                }
            }
            addBehaviour(new PideFicherosAlumno(this.myAgent, tes2, test, true));
        }
    }

    public class SeleccionarFicherosAlumnoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public SeleccionarFicherosAlumnoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            Test test = (Test) tes2.getParametro();

            addBehaviour(new PideFicherosAlumno(this.myAgent, tes2, test, false));
        }
    }

    public class PideCasosBeha extends OneShotBehaviour {

        private Testigo tes2;

        public PideCasosBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            Test test = null;
            String nombre = request.getParameter("NombreTest");
            if (nombre != null) {
                String descripcion = request.getParameter("DescripcionTest");
                String ejecutable = request.getParameter("EjecutableTest");
                if (ejecutable != null){
                    test = new Test(nombre, descripcion, ejecutable);
                }
                else{
                test = new Test(nombre, descripcion);
                }
            }
            addBehaviour(new PideCasos(this.myAgent, tes2, test, true));
        }
    }

    public class SeleccionarCasosBeha extends OneShotBehaviour {

        private Testigo tes2;

        public SeleccionarCasosBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            Test test = (Test) tes2.getParametro();

            addBehaviour(new PideCasos(this.myAgent, tes2, test, false));
        }
    }

    public class PideFicherosINBeha extends OneShotBehaviour {

        private Testigo tes2;

        public PideFicherosINBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            Caso caso = null;
            String nombre = request.getParameter("NombreCaso");
            if (nombre != null) {
                caso = new Caso(nombre);
            }
            addBehaviour(new PideFicherosIN(this.myAgent, tes2, caso, true));
        }
    }

    public class SeleccionarFicherosINBeha extends OneShotBehaviour {

        private Testigo tes2;

        public SeleccionarFicherosINBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            Caso caso = (Caso) tes2.getParametro();

            addBehaviour(new PideFicherosIN(this.myAgent, tes2, caso, false));
        }
    }

    public class PideFicherosOUTBeha extends OneShotBehaviour {

        private Testigo tes2;

        public PideFicherosOUTBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            Caso caso = null;
            String nombre = request.getParameter("NombreCaso");
            if (nombre != null) {
                caso = new Caso(nombre);
            }
            addBehaviour(new PideFicherosOUT(this.myAgent, tes2, caso, true));
        }
    }

    public class SeleccionarFicherosOUTBeha extends OneShotBehaviour {

        private Testigo tes2;

        public SeleccionarFicherosOUTBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            Caso caso = (Caso) tes2.getParametro();

            addBehaviour(new PideFicherosOUT(this.myAgent, tes2, caso, false));
        }
    }

    public class ModificarPracticaBeha extends OneShotBehaviour {

        private Testigo tes2;

        public ModificarPracticaBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest param1 = (HttpServletRequest) tes2.getParametro();
            String descripcion = param1.getParameter("DescripcionPractica");
            String fechaEntrega = param1.getParameter("FechaPractica");
            String nombre = param1.getParameter("NombrePractica");
            Practica pt = new Practica(nombre, descripcion, fechaEntrega);
            addBehaviour(new ModificarPractica(this.myAgent, tes2, pt));
        }
    }

    public class ModificarTestBeha extends OneShotBehaviour {

        private Testigo tes2;

        public ModificarTestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest param1 = (HttpServletRequest) tes2.getParametro();
            String descripcion = param1.getParameter("DescripcionTest");
            String nombre = param1.getParameter("NombreTest");
            String ejecutable = param1.getParameter("EjecutableTest");
            Test te;
            if (ejecutable != null){
                    te = new Test(nombre, descripcion, ejecutable);
                }
                else{
                    te = new Test(nombre, descripcion);
                }
            addBehaviour(new ModificarTest(this.myAgent, tes2, te));
        }
    }

        public class ModificarEjecutableBeha extends OneShotBehaviour {

        private Testigo tes2;

        public ModificarEjecutableBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            addBehaviour(new ModificarEjecutable(this.myAgent, tes2, param1));
        }
    }

    public class ModificarFicherosPropiosBeha extends OneShotBehaviour {

        private Testigo tes2;

        public ModificarFicherosPropiosBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            StringTokenizer tokenizer = new StringTokenizer(param1, "#");
            String nombre = tokenizer.nextToken();
            String codigo = tokenizer.nextToken();


            FicheroPropio fp = new FicheroPropio(nombre, codigo);
            addBehaviour(new ModificarFicherosPropios(this.myAgent, tes2, fp));

        }
    }

    public class ModificarFicherosINBeha extends OneShotBehaviour {

        private Testigo tes2;

        public ModificarFicherosINBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            StringTokenizer tokenizer = new StringTokenizer(param1, "#");
            String nombre = tokenizer.nextToken();
            String contenido = tokenizer.nextToken();


            FicheroIN fi = new FicheroIN(nombre, contenido);
            addBehaviour(new ModificarFicherosIN(this.myAgent, tes2, fi));

        }
    }

    public class ModificarFicherosOUTBeha extends OneShotBehaviour {

        private Testigo tes2;

        public ModificarFicherosOUTBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            StringTokenizer tokenizer = new StringTokenizer(param1, "#");
            String nombre = tokenizer.nextToken();
            String contenido = tokenizer.nextToken();


            FicheroOUT fo = new FicheroOUT(nombre, contenido);
            addBehaviour(new ModificarFicherosOUT(this.myAgent, tes2, fo));

        }
    }

    public class CrearPracticaBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearPracticaBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombrePractica");
            String descripcion = request.getParameter("DescripcionPractica");
            String fechaEntrega = request.getParameter("FechaPractica");
            Practica practica = new Practica(nombre, descripcion, fechaEntrega);

            addBehaviour(new CrearPractica(this.myAgent, tes2, practica));
        }
    }

    public class CrearTestBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearTestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreTest");
            String descripcion = request.getParameter("DescripcionTest");
            Test test = new Test(nombre, descripcion);

            addBehaviour(new CrearTest(this.myAgent, tes2, test));
        }
    }

    public class CrearFicheroPropioBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearFicheroPropioBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            StringTokenizer tokenizer = new StringTokenizer(param1, "#");
            String nombre = tokenizer.nextToken();
            String codigo = tokenizer.nextToken();


            FicheroPropio fp = new FicheroPropio(nombre, codigo);
            addBehaviour(new CrearFicheroPropio(this.myAgent, tes2, fp));

        }
    }

    public class CrearFicheroAlumnoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearFicheroAlumnoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreFicheroAlumno");
            FicheroAlumno fa = new FicheroAlumno(nombre);

            addBehaviour(new CrearFicheroAlumno(this.myAgent, tes2, fa));
        }
    }

    public class CrearCasoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearCasoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreCaso");
            Caso ca = new Caso(nombre);

            addBehaviour(new CrearCaso(this.myAgent, tes2, ca));
        }
    }

    public class CrearFicheroINBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearFicheroINBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            StringTokenizer tokenizer = new StringTokenizer(param1, "#");
            String nombre = tokenizer.nextToken();
            String contenido = tokenizer.nextToken();


            FicheroIN fi = new FicheroIN(nombre, contenido);
            addBehaviour(new CrearFicheroIN(this.myAgent, tes2, fi));

        }
    }

    public class CrearFicheroOUTBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CrearFicheroOUTBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            String param1 = (String) tes2.getParametro();

            StringTokenizer tokenizer = new StringTokenizer(param1, "#");
            String nombre = tokenizer.nextToken();
            String contenido = tokenizer.nextToken();


            FicheroOUT fo = new FicheroOUT(nombre, contenido);
            addBehaviour(new CrearFicheroOUT(this.myAgent, tes2, fo));

        }
    }

    public class EliminarPracticaBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarPracticaBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombrePractica");
            String descripcion = request.getParameter("DescripcionPractica");
            String fechaEntrega = request.getParameter("FechaPractica");
            Practica practica = new Practica(nombre, descripcion, fechaEntrega);

            addBehaviour(new EliminarPractica(this.myAgent, tes2, practica));
        }
    }

    public class EliminarCasoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarCasoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreCaso");
            Caso ca = new Caso(nombre);

            addBehaviour(new EliminarCaso(this.myAgent, tes2, ca));
        }
    }

    public class EliminarTestBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarTestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreTest");
            String descripcion = request.getParameter("DescripcionTest");
            Test test = new Test(nombre, descripcion);

            addBehaviour(new EliminarTest(this.myAgent, tes2, test));
        }
    }

    public class EliminarFicheroPropioBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarFicheroPropioBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreFichero");
            String descripcion = request.getParameter("CodigoFichero");
            FicheroPropio fp = new FicheroPropio(nombre, descripcion);

            addBehaviour(new EliminarFicheroPropio(this.myAgent, tes2, fp));
        }
    }

    public class EliminarFicheroAlumnoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarFicheroAlumnoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreFicheroAlumno");
            FicheroAlumno fa = new FicheroAlumno(nombre);

            addBehaviour(new EliminarFicheroAlumno(this.myAgent, tes2, fa));
        }
    }

    public class EliminarFicheroINBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarFicheroINBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreFichero");
            String contenido = request.getParameter("ContenidoFichero");

            FicheroIN fi = new FicheroIN(nombre, contenido);
            addBehaviour(new EliminarFicheroIN(this.myAgent, tes2, fi));

        }
    }

    public class EliminarFicheroOUTBeha extends OneShotBehaviour {

        private Testigo tes2;

        public EliminarFicheroOUTBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombre = request.getParameter("NombreFichero");
            String contenido = request.getParameter("ContenidoFichero");


            FicheroOUT fo = new FicheroOUT(nombre, contenido);
            addBehaviour(new EliminarFicheroOUT(this.myAgent, tes2, fo));

        }
    }

    /****************COMPORTAMIENTOS PARA COPIAR**************/
    public class CopiarTestBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CopiarTestBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombrePractica = request.getParameter("NombrePracticaACopiar");
            String nombreTest = request.getParameter("NombreTest");
            String descripcion = request.getParameter("DescripcionTest");
            String ejecutable = request.getParameter("EjecutableTest");

            String nombreTestACopiar = request.getParameter("NombreTestACopiar");
            String descripcionTestACopiar = request.getParameter("DescripcionTestACopiar");

            Practica practica = new Practica(nombrePractica);
            Test test = new Test(nombreTest, descripcion, ejecutable);
            Test testACopiar = new Test(nombreTestACopiar, descripcionTestACopiar);

            addBehaviour(new CopiarTest(this.myAgent, tes2, practica, test, testACopiar));
        }
    }

    public class CopiarFicheroPropioBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CopiarFicheroPropioBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {

            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombreFichero = request.getParameter("NombreFichero");
            String codigoFicheroACopiar = request.getParameter("CodigoFicheroACopiar");

            FicheroPropio fp = new FicheroPropio(nombreFichero, codigoFicheroACopiar);
            addBehaviour(new CopiarFicheroPropio(this.myAgent, tes2, fp));

        }
    }

    public class CopiarFicheroAlumnoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CopiarFicheroAlumnoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {

            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombreFichero = request.getParameter("NombreFichero");

            FicheroAlumno fp = new FicheroAlumno(nombreFichero);
            addBehaviour(new CopiarFicheroAlumno(this.myAgent, tes2, fp));

        }
    }

    public class CopiarCasoBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CopiarCasoBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {
            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombrePractica = request.getParameter("NombrePracticaACopiar");
            String nombreTestACopiar = request.getParameter("NombreTestACopiar");
            String nombreCasoACopiar = request.getParameter("NombreCasoACopiar");

            String nombreCaso = request.getParameter("NombreCaso");

            Practica practica = new Practica(nombrePractica);
            Test test = new Test(nombreTestACopiar);
            Caso casoACopiar = new Caso(nombreCasoACopiar);
            Caso caso = new Caso(nombreCaso);
            addBehaviour(new CopiarCaso(this.myAgent, tes2, practica, test, casoACopiar, caso));

        }
    }

    public class CopiarFicheroINBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CopiarFicheroINBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {

            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombreFichero = request.getParameter("NombreFichero");
            String contenido = request.getParameter("ContenidoFichero");

            FicheroIN fi = new FicheroIN(nombreFichero, contenido);
            addBehaviour(new CopiarFicheroIN(this.myAgent, tes2, fi));

        }
    }

        public class CopiarFicheroOUTBeha extends OneShotBehaviour {

        private Testigo tes2;

        public CopiarFicheroOUTBeha(Agent _a, Testigo tes1) {
            super(_a);
            this.tes2 = tes1;
        }

        public void action() {

            HttpServletRequest request = (HttpServletRequest) tes2.getParametro();
            String nombreFichero = request.getParameter("NombreFichero");
            String contenido = request.getParameter("ContenidoFichero");

            FicheroOUT fo = new FicheroOUT(nombreFichero, contenido);
            addBehaviour(new CopiarFicheroOUT(this.myAgent, tes2, fo));

        }
    }

    public class ProcesaTestigo extends OneShotBehaviour {

        private Testigo testigo;

        public ProcesaTestigo(Testigo _tes) {

            this.testigo = _tes;

        }

        public void action() {
            while (this.myAgent == null) {
                System.out.println("AGENT ES NULL");
            }

            InterfazJSPGestor agent = (InterfazJSPGestor) this.myAgent;
            while (!agent.FinSetup) {

                System.out.println("FINSETUP");
            }


            if (this.testigo != null) {

                switch (testigo.getOperacion()) {

                    case autenticar:
                        addBehaviour(new AutenticaRequestBeha(agent, testigo));
                        break;

                    case pedirPracticas:
                        addBehaviour(new PidePracticasBehavior(agent, testigo));
                        break;

                    case modificarPractica:
                        addBehaviour(new ModificarPracticaBeha(agent, testigo));
                        break;

                    case pedirTests:
                        addBehaviour(new PideTestRequestBeha(agent, testigo));
                        break;

                    case modificarTest:
                        addBehaviour(new ModificarTestBeha(agent, testigo));
                        break;

                    case modificarEjecutable:
                        addBehaviour(new ModificarEjecutableBeha(agent, testigo));
                        break;

                    case pedirFicherosPropios:
                        addBehaviour(new PideFicherosPropiosBeha(agent, testigo));
                        break;

                    case modificarFicherosPropios:
                        addBehaviour(new ModificarFicherosPropiosBeha(agent, testigo));
                        break;

                    case pedirCasos:
                        addBehaviour(new PideCasosBeha(agent, testigo));
                        break;

                    case pedirFicherosAlumno:
                        addBehaviour(new PideFicherosAlumnoBeha(agent, testigo));
                        break;

                    case pedirFicherosIN:
                        addBehaviour(new PideFicherosINBeha(agent, testigo));
                        break;

                    case pedirFicherosOUT:
                        addBehaviour(new PideFicherosOUTBeha(agent, testigo));
                        break;

                    case modificarFicherosIN:
                        addBehaviour(new ModificarFicherosINBeha(agent, testigo));
                        break;

                    case modificarFicherosOUT:
                        addBehaviour(new ModificarFicherosOUTBeha(agent, testigo));
                        break;

                    case ultimaPractica:
                        testigo.setResultado(ultimaPractica);
                        break;

                    case ultimoTest:
                        testigo.setResultado(ultimoTest);
                        break;

                    case ultimoCaso:
                        testigo.setResultado(ultimoCaso);
                        break;
                    case crearPractica:
                        addBehaviour(new CrearPracticaBeha(agent, testigo));
                        break;

                    case crearTest:
                        addBehaviour(new CrearTestBeha(agent, testigo));
                        break;

                    case crearFicheroPropio:
                        addBehaviour(new CrearFicheroPropioBeha(agent, testigo));
                        break;

                    case crearFicheroAlumno:
                        addBehaviour(new CrearFicheroAlumnoBeha(agent, testigo));
                        break;


                    case crearCaso:
                        addBehaviour(new CrearCasoBeha(agent, testigo));
                        break;

                    case crearFicheroIN:
                        addBehaviour(new CrearFicheroINBeha(agent, testigo));
                        break;


                    case crearFicheroOUT:
                        addBehaviour(new CrearFicheroOUTBeha(agent, testigo));
                        break;

                    case eliminarPractica:
                        addBehaviour(new EliminarPracticaBeha(agent, testigo));
                        break;

                    case eliminarTest:
                        addBehaviour(new EliminarTestBeha(agent, testigo));
                        break;

                    case eliminarFicheroPropio:
                        addBehaviour(new EliminarFicheroPropioBeha(agent, testigo));
                        break;

                    case eliminarCaso:
                        addBehaviour(new EliminarCasoBeha(agent, testigo));
                        break;

                    case eliminarFicheroAlumno:
                        addBehaviour(new EliminarFicheroAlumnoBeha(agent, testigo));
                        break;

                    case eliminarFicheroIN:
                        addBehaviour(new EliminarFicheroINBeha(agent, testigo));
                        break;

                    case eliminarFicheroOUT:
                        addBehaviour(new EliminarFicheroOUTBeha(agent, testigo));
                        break;

                    case seleccionarTest:
                        addBehaviour(new SeleccionarTestBeha(agent, testigo));
                        break;

                    case copiarTest:
                        addBehaviour(new CopiarTestBeha(agent, testigo));
                        break;


                    case seleccionarFicherosPropios:
                        addBehaviour(new SeleccionarFicherosPropiosBeha(agent, testigo));
                        break;


                    case copiarFicherosPropios:
                        addBehaviour(new CopiarFicheroPropioBeha(agent, testigo));
                        break;


                    case seleccionarFicherosAlumno:
                        addBehaviour(new SeleccionarFicherosAlumnoBeha(agent, testigo));
                        break;

                    case copiarFicherosAlumno:
                        addBehaviour(new CopiarFicheroAlumnoBeha(agent, testigo));
                        break;


                    case seleccionarCasos:
                        addBehaviour(new SeleccionarCasosBeha(agent, testigo));
                        break;

                    case copiarCasos:
                        addBehaviour(new CopiarCasoBeha(agent, testigo));
                        break;


                    case seleccionarFicherosIN:
                        addBehaviour(new SeleccionarFicherosINBeha(agent, testigo));
                        break;

                    case copiarFicherosIN:
                        addBehaviour(new CopiarFicheroINBeha(agent, testigo));
                        break;


                    case seleccionarFicherosOUT:
                        addBehaviour(new SeleccionarFicherosOUTBeha(agent, testigo));
                        break;

                    case copiarFicherosOUT:
                        addBehaviour(new CopiarFicheroOUTBeha(agent, testigo));
                        break;


                    default:
                        testigo.setResultado("-");
                        break;
                }
            }
        }
    }
    public boolean FinSetup = false;

    /**
     * Method to proccess a testigo object. Create new
     * "ProcesaTestigo" behaviour to proccess <b>one</b>
     * "Testigo" only.
     * (Replace the old "Put2Object" method)
     * @param testigo
     */
    public void sendTestigo(Testigo testigo) {

        this.addBehaviour(new ProcesaTestigo(testigo));

    }

    @Override
    protected void setup() {
        super.setup();
        FinSetup = true;
    }

    public boolean isFinSetup() {
        return FinSetup;
    }
}
