<%@ page import="jade.core.*"%>
<%@ page import="jade.core.Agent.*"%>
<%@ page import="jade.core.Runtime"%>
<%@ page import="jade.wrapper.*"%>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import="PACA.util.*"%> 




<jsp:useBean id="fake" class="java.util.Random" scope="application">
	<%
		//String[] args = {"-container"}; 
		//jade.Boot.main(args);
		//System.out.println("Contenedor Jade Iniciado.");

	%>
</jsp:useBean>


<jsp:useBean id="interfaz" class="PACA.util.AgentBean" scope="session">
	
	<%

		String nombre = "USER" + session.getId();
		Runtime rt;
		Profile p;
		ContainerController cc;
		AgentController agentInterfaz = null;
		InterfazJSP agent = null;

		try {
			//interfaz.doStart(nombre);
			rt = Runtime.instance();
			p = new ProfileImpl(false);
			cc = rt.createAgentContainer(p);
			agent = new InterfazJSP();
			agentInterfaz = cc.acceptNewAgent(nombre, agent);
			if (agentInterfaz != null) {
				agentInterfaz.start();
				interfaz.setAgentInterfaz(agent);
				interfaz.setAgentController(agentInterfaz);
				while (!agent.isFinSetup()) {
					System.out.println("Esperando al fin... ");
				}


			} else {
				System.out.println("Agente no Arrancado" + agentInterfaz.getState().getName());
			}
		} catch (Exception ex) {
			out.println(ex);
			ex.printStackTrace();
		}

	%>    
</jsp:useBean>


<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@page import="PACA.ontology.pacaOntology"%>
<%@page import="PACA.agents.Interfaz"%>
<%@page import="PACA.agents.InterfazJSP"%>
<html>
	
	<head>
		<title>
			Practicas Disponibles.
		</title>
		<LINK REL=STYLESHEET TYPE="text/css" HREF="./estilos/estiloPaca.css">
		<SCRIPT TYPE="text/javascript">
			 <!--
			 
			 salida = true;
			 
			 function exit()
			 {
				 if (salida)
					 window.open("salida.jsp",'frame','width=580,height=480,scrollbars=yes,resizable=yes')
				 return true;
			 }
			 
			 
			 function desactivarBoton() {
				 document.formpracticas.seleccionar.disabled=true;
			 }
			 
			 //-->
		</SCRIPT>
	</head>
	
	<body onUnload="exit();">
		
		<%@ include file="cab.html"%>
		<%@ include file="barra0.html"%>
		
		<%






		boolean autenticado = false;

		//autenticado = interfaz.doAutenticacionRequest(request);
		//autenticado=false;
		Testigo resultado = new Testigo();
		resultado.setOperacion(Testigo.Operaciones.autenticar);
		resultado.setParametro((HttpServletRequest) request);


		//interfaz.getAtributo().putO2AObject(resultado,AgentController.SYNC);
		interfaz.sendTestigo(resultado);


		while (!resultado.isRelleno()) {
		}

		autenticado = resultado.isResultadoB();

		%>
		
		
		<%

		if (!autenticado) {
		%>
		
		<h2 class="error">
			<p class="center">ERROR!!! Usuario no autenticado  </p> 
		</h2>
		<br>
		<p class="error" style="text-align: center;">
			El usuario "<%= request.getParameter("user_id") %>" no ha podido ser validado. 
			Por favor, utilice su nombre de usuario y password personal o 
			revise su nombre de usuario y contrase�a.
		</p>
		<br>
		<br>
		<p class="center">
			<a href="javascript:history.go(-1)" onclick="javascript:salida=false;">Volver a la pagina de autenticaci&oacute;n.</a>
		</p>
		<%
		} else {
			//interfaz.setAlumnoID(request.getParameter("user_id"));
			//interfaz.setAlumnoPass(request.getParameter("password"));
%>
		
		<br><br><br>
		<p class="center" class="color">
		Seleccione la pr&aacute;ctica a evaluar.  </p><br>
		
		<%
			// Aqu� hacemos la petici�n de las pr�cticas disponibles y las
			// mostramos en un formulario

			//String[] pract = interfaz.doPeticion();


			Testigo resultado3 = new Testigo();
			resultado3.setOperacion(Testigo.Operaciones.buscarCorrector);

			//interfaz.getAtributo().putO2AObject(resultado3,AgentController.SYNC);
			interfaz.sendTestigo(resultado3);

			while (!resultado3.isRelleno()) {
			}



			//-----------------------------------------------------------------------

			Testigo resultado2 = new Testigo();
			resultado2.setOperacion(Testigo.Operaciones.pedirPracticas);

			//interfaz.getAtributo().putO2AObject(resultado2,AgentController.SYNC);
			interfaz.sendTestigo(resultado2);

			while (!resultado2.isRelleno()) {
			}

			String[] pract = (String[]) resultado2.getResultado();







		%>
		<p  class="center">
		<form method="post" name="formpracticas" action="peticionTest.jsp" onsubmit="desactivarBoton();">
			<div class="form"><BR>
				<table class="color">
					<tr>
						
						<td style="width: 20%;">
							&nbsp;
						</td>
						<td style="width: 60%; text-align: center;">
							<SELECT size=1 cols=<%= pract.length %> NAME=practica>
							<%
			// Rellenamos todas las opciones

			for (int i = 0; i < pract.length; i++) {
							%>
							<OPTION value=<%= pract[i] %>> <%= pract[i] %>
									<%
			}
									%>
									
									</SELECT>
						</td>
						<td style="width: 20%;">
							&nbsp;
						</td>
					</tr>
				</table>
				<BR>
			</div>
			<BR><BR><BR>
			<p style="text-align: right;">
				 <input type="submit" name="seleccionar" value="Seleccionar" onclick="javascript:salida=false;"></p>
		</form>
		
		
		<%
		}
		%>
		
		
	</body>
</html>


