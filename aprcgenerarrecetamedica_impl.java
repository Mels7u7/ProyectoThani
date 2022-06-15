package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aprcgenerarrecetamedica_impl extends GXWebReport
{
   public aprcgenerarrecetamedica_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV8CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
      }
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 256, 16834, 11923, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         AV53TelefonoThani = "391-0491 | 391-0492" ;
         AV15CorreoThani = "contacto@thanitech.pe" ;
         AV21DireccionThani = "Calle Fermin Tangüis 145 Of. 302 Urb. Santa Catalina - La Victoria" ;
         AV55TituloEpicrisis = "RECETA MÉDICA" ;
         AV10Cita.Load(AV8CitaId);
         AV33Paciente.Load(AV10Cita.getgxTv_SdtCita_Pacienteid());
         AV41PacienteId = AV33Paciente.getgxTv_SdtPaciente_Pacienteid() ;
         AV35PacienteApellidoPaterno = AV10Cita.getgxTv_SdtCita_Pacienteapellidopaterno() ;
         AV34PacienteApellidoMaterno = AV10Cita.getgxTv_SdtCita_Pacienteapellidomaterno() ;
         AV42PacienteNombres = AV10Cita.getgxTv_SdtCita_Pacientenombres() ;
         if ( GXutil.strcmp(AV33Paciente.getgxTv_SdtPaciente_Pacientetipodocumento(), "1") == 0 )
         {
            AV46PacienteTipoDocumento = "DNI" ;
         }
         else
         {
            AV46PacienteTipoDocumento = "OTRO" ;
         }
         AV43PacienteNroDocumento = AV33Paciente.getgxTv_SdtPaciente_Pacientenrodocumento() ;
         GXt_dtime1 = GXutil.resetTime( AV33Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento() );
         AV26edad = (short)(GXutil.age( GXt_dtime1, GXutil.now( ))) ;
         AV40PacienteFechaNacimiento = localUtil.dtoc( AV33Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento(), 3, "/") + " (Edad: " + GXutil.str( AV26edad, 4, 0) + " años)" ;
         AV25DisponibilidadId = AV10Cita.getgxTv_SdtCita_Sgcitadisponibilidadid() ;
         AV22Disponibilidad.Load(AV25DisponibilidadId);
         AV28EspecialidadId = AV22Disponibilidad.getgxTv_SdtDisponibilidad_Especialidadid() ;
         AV27Especialidad.Load(AV28EspecialidadId);
         AV29EspecialidadNombre = AV27Especialidad.getgxTv_SdtEspecialidad_Especialidadcodigo() + " - " + AV27Especialidad.getgxTv_SdtEspecialidad_Especialidadnombre() ;
         AV50SedeId = AV22Disponibilidad.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid() ;
         AV49Sede.Load(AV50SedeId);
         AV51SedeNombre = AV49Sede.getgxTv_SdtSede_Sedenombre() + " / " + AV49Sede.getgxTv_SdtSede_Clinicanombrecomercial() ;
         AV47ProfesionalId = AV22Disponibilidad.getgxTv_SdtDisponibilidad_Profesionalid() ;
         AV9Profesional.Load(AV47ProfesionalId);
         AV48ProfesionalNombreCompleto = AV9Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() + " " + AV9Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno() + ", " + AV9Profesional.getgxTv_SdtProfesional_Profesionalnombres() + " - CMP:" + AV9Profesional.getgxTv_SdtProfesional_Profesionalcop() ;
         AV23DisponibilidadFecha = AV22Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha() ;
         AV24DisponibilidadHoraInicio = AV22Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio() ;
         AV13CitaInforme = AV10Cita.getgxTv_SdtCita_Citainforme() ;
         AV11CitaAntecedentes = AV10Cita.getgxTv_SdtCita_Citaantecedentes() ;
         AV14CitaMotivoConsulta = AV10Cita.getgxTv_SdtCita_Citamotivoconsulta() ;
         AV12CitaCode = AV10Cita.getgxTv_SdtCita_Citacode() ;
         AV54TipoConsulta = com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)AV22Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadtipocita()) ;
         AV36PacienteApeNom = AV35PacienteApellidoPaterno + " " + AV34PacienteApellidoMaterno + " " + AV42PacienteNombres ;
         AV38PacienteDNI = AV43PacienteNroDocumento ;
         AV39PacienteEdad = GXutil.str( AV26edad, 4, 0) + " " + "años" ;
         /* Using cursor P008Q2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV41PacienteId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A20PacienteId = P008Q2_A20PacienteId[0] ;
            A216PacienteSexo = P008Q2_A216PacienteSexo[0] ;
            AV52SexoPaciente = com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A216PacienteSexo) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV31MedicoNomAp = AV9Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() + " " + AV9Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno() + ", " + AV9Profesional.getgxTv_SdtProfesional_Profesionalnombres() ;
         AV30MedicoCOP = AV9Profesional.getgxTv_SdtProfesional_Profesionalcop() ;
         h8Q0( false, 311) ;
         getPrinter().GxDrawBitMap(context.getHttpContext().getImagePath( "62fabb4b-713d-4bd3-9f52-cde8b0a8f851", "", context.getHttpContext().getTheme( )), 100, Gx_line+67, 285, Gx_line+131) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha:", 100, Gx_line+233, 142, Gx_line+249, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( AV23DisponibilidadFecha, "99/99/99"), 192, Gx_line+233, 319, Gx_line+250, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Diagnostico: ", 250, Gx_line+283, 700, Gx_line+311, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("CIE 10: ", 100, Gx_line+283, 253, Gx_line+311, 1, 0, 0, 1) ;
         getPrinter().GxDrawRect(100, Gx_line+283, 700, Gx_line+311, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(250, Gx_line+283, 250, Gx_line+311, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Consulta:", 100, Gx_line+250, 183, Gx_line+266, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54TipoConsulta, "")), 192, Gx_line+250, 297, Gx_line+267, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawLine(100, Gx_line+150, 700, Gx_line+150, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53TelefonoThani, "")), 442, Gx_line+117, 700, Gx_line+132, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15CorreoThani, "")), 442, Gx_line+100, 700, Gx_line+115, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21DireccionThani, "")), 300, Gx_line+83, 701, Gx_line+98, 2, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 20, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("RECETA MÉDICA", 292, Gx_line+17, 540, Gx_line+49, 0+256, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente:", 100, Gx_line+167, 158, Gx_line+184, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("DNI:", 100, Gx_line+183, 126, Gx_line+199, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("Edad:", 300, Gx_line+183, 334, Gx_line+199, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("Sexo:", 433, Gx_line+183, 466, Gx_line+199, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("Médico:", 100, Gx_line+200, 147, Gx_line+216, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("CMP:", 100, Gx_line+217, 132, Gx_line+233, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36PacienteApeNom, "")), 192, Gx_line+167, 700, Gx_line+184, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38PacienteDNI, "")), 192, Gx_line+183, 284, Gx_line+200, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31MedicoNomAp, "")), 192, Gx_line+200, 700, Gx_line+217, 0, 0, 0, 1) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39PacienteEdad, "")), 342, Gx_line+183, 392, Gx_line+200, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52SexoPaciente, "")), 475, Gx_line+183, 617, Gx_line+200, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30MedicoCOP, "")), 192, Gx_line+217, 325, Gx_line+234, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+311) ;
         /* Using cursor P008Q3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A23DiagnosticoId = P008Q3_A23DiagnosticoId[0] ;
            A19CitaId = P008Q3_A19CitaId[0] ;
            A107DiagnosticoCodigo = P008Q3_A107DiagnosticoCodigo[0] ;
            A108DiagnosticoDescripcion = P008Q3_A108DiagnosticoDescripcion[0] ;
            A22CitaDiagnosticoId = P008Q3_A22CitaDiagnosticoId[0] ;
            A107DiagnosticoCodigo = P008Q3_A107DiagnosticoCodigo[0] ;
            A108DiagnosticoDescripcion = P008Q3_A108DiagnosticoDescripcion[0] ;
            h8Q0( false, 21) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A108DiagnosticoDescripcion, "")), 250, Gx_line+0, 700, Gx_line+20, 1+16, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A107DiagnosticoCodigo, "")), 108, Gx_line+0, 248, Gx_line+20, 1, 0, 0, 1) ;
            getPrinter().GxDrawLine(100, Gx_line+0, 100, Gx_line+20, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(250, Gx_line+0, 250, Gx_line+20, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(700, Gx_line+0, 700, Gx_line+20, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(100, Gx_line+20, 700, Gx_line+20, 1, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+21) ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         h8Q0( false, 50) ;
         getPrinter().GxDrawLine(250, Gx_line+22, 250, Gx_line+50, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawRect(100, Gx_line+22, 700, Gx_line+50, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medicamento", 100, Gx_line+33, 250, Gx_line+50, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("Indicaciones", 325, Gx_line+33, 692, Gx_line+50, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("Cant.", 250, Gx_line+33, 308, Gx_line+50, 1, 0, 0, 1) ;
         getPrinter().GxDrawLine(315, Gx_line+22, 315, Gx_line+50, 1, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+50) ;
         /* Using cursor P008Q4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A42MedicamentoId = P008Q4_A42MedicamentoId[0] ;
            n42MedicamentoId = P008Q4_n42MedicamentoId[0] ;
            A272RecetaMedicaFlag = P008Q4_A272RecetaMedicaFlag[0] ;
            n272RecetaMedicaFlag = P008Q4_n272RecetaMedicaFlag[0] ;
            A19CitaId = P008Q4_A19CitaId[0] ;
            A332RecetaIndicaciones = P008Q4_A332RecetaIndicaciones[0] ;
            A269RecetaMedicaCantidad = P008Q4_A269RecetaMedicaCantidad[0] ;
            n269RecetaMedicaCantidad = P008Q4_n269RecetaMedicaCantidad[0] ;
            A230MedicamentoNombre = P008Q4_A230MedicamentoNombre[0] ;
            A50RecetaMedicaId = P008Q4_A50RecetaMedicaId[0] ;
            A230MedicamentoNombre = P008Q4_A230MedicamentoNombre[0] ;
            h8Q0( false, 40) ;
            getPrinter().GxDrawLine(315, Gx_line+0, 315, Gx_line+40, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawRect(100, Gx_line+0, 700, Gx_line+40, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(250, Gx_line+0, 250, Gx_line+40, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A230MedicamentoNombre, "")), 100, Gx_line+0, 250, Gx_line+40, 1, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9")), 250, Gx_line+0, 310, Gx_line+40, 1, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A332RecetaIndicaciones, "")), 316, Gx_line+0, 696, Gx_line+40, 1, 0, 0, 1) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+40) ;
            pr_default.readNext(2);
         }
         pr_default.close(2);
         h8Q0( false, 30) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("*Este documento ha sido generado automáticamente por la plataforma THANI", 100, Gx_line+12, 700, Gx_line+26, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+30) ;
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h8Q0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void h8Q0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
      add_metrics1( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   public void add_metrics1( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", true, false, 57, 15, 72, 163,  new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 19, 29, 34, 34, 55, 45, 15, 21, 21, 24, 36, 17, 21, 17, 17, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 21, 21, 36, 36, 36, 38, 60, 43, 45, 45, 45, 41, 38, 48, 45, 17, 34, 45, 38, 53, 45, 48, 41, 48, 45, 41, 38, 45, 41, 57, 41, 41, 38, 21, 17, 21, 36, 34, 21, 34, 38, 34, 38, 34, 21, 38, 38, 17, 17, 34, 17, 55, 38, 38, 38, 38, 24, 34, 21, 38, 33, 49, 34, 34, 31, 24, 17, 24, 36, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 21, 34, 34, 34, 34, 17, 34, 21, 46, 23, 34, 36, 21, 46, 34, 25, 34, 21, 21, 21, 36, 34, 21, 20, 21, 23, 34, 52, 52, 52, 38, 45, 45, 45, 45, 45, 45, 62, 45, 41, 41, 41, 41, 17, 17, 17, 17, 45, 45, 48, 48, 48, 48, 48, 36, 48, 45, 45, 45, 45, 41, 41, 38, 34, 34, 34, 34, 34, 34, 55, 34, 34, 34, 34, 34, 17, 17, 17, 17, 38, 38, 38, 38, 38, 38, 38, 34, 38, 38, 38, 38, 38, 34, 38, 34}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      AV53TelefonoThani = "" ;
      AV15CorreoThani = "" ;
      AV21DireccionThani = "" ;
      AV55TituloEpicrisis = "" ;
      AV10Cita = new com.projectthani.SdtCita(remoteHandle);
      AV33Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV35PacienteApellidoPaterno = "" ;
      AV34PacienteApellidoMaterno = "" ;
      AV42PacienteNombres = "" ;
      AV46PacienteTipoDocumento = "" ;
      AV43PacienteNroDocumento = "" ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      AV40PacienteFechaNacimiento = "" ;
      AV22Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV27Especialidad = new com.projectthani.SdtEspecialidad(remoteHandle);
      AV29EspecialidadNombre = "" ;
      AV49Sede = new com.projectthani.SdtSede(remoteHandle);
      AV51SedeNombre = "" ;
      AV9Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV48ProfesionalNombreCompleto = "" ;
      AV23DisponibilidadFecha = GXutil.nullDate() ;
      AV24DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV13CitaInforme = "" ;
      AV11CitaAntecedentes = "" ;
      AV14CitaMotivoConsulta = "" ;
      AV12CitaCode = "" ;
      AV54TipoConsulta = "" ;
      AV36PacienteApeNom = "" ;
      AV38PacienteDNI = "" ;
      AV39PacienteEdad = "" ;
      scmdbuf = "" ;
      P008Q2_A20PacienteId = new int[1] ;
      P008Q2_A216PacienteSexo = new String[] {""} ;
      A216PacienteSexo = "" ;
      AV52SexoPaciente = "" ;
      AV31MedicoNomAp = "" ;
      AV30MedicoCOP = "" ;
      P008Q3_A23DiagnosticoId = new int[1] ;
      P008Q3_A19CitaId = new int[1] ;
      P008Q3_A107DiagnosticoCodigo = new String[] {""} ;
      P008Q3_A108DiagnosticoDescripcion = new String[] {""} ;
      P008Q3_A22CitaDiagnosticoId = new int[1] ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      P008Q4_A42MedicamentoId = new short[1] ;
      P008Q4_n42MedicamentoId = new boolean[] {false} ;
      P008Q4_A272RecetaMedicaFlag = new byte[1] ;
      P008Q4_n272RecetaMedicaFlag = new boolean[] {false} ;
      P008Q4_A19CitaId = new int[1] ;
      P008Q4_A332RecetaIndicaciones = new String[] {""} ;
      P008Q4_A269RecetaMedicaCantidad = new short[1] ;
      P008Q4_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P008Q4_A230MedicamentoNombre = new String[] {""} ;
      P008Q4_A50RecetaMedicaId = new short[1] ;
      A332RecetaIndicaciones = "" ;
      A230MedicamentoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.aprcgenerarrecetamedica__default(),
         new Object[] {
             new Object[] {
            P008Q2_A20PacienteId, P008Q2_A216PacienteSexo
            }
            , new Object[] {
            P008Q3_A23DiagnosticoId, P008Q3_A19CitaId, P008Q3_A107DiagnosticoCodigo, P008Q3_A108DiagnosticoDescripcion, P008Q3_A22CitaDiagnosticoId
            }
            , new Object[] {
            P008Q4_A42MedicamentoId, P008Q4_n42MedicamentoId, P008Q4_A272RecetaMedicaFlag, P008Q4_n272RecetaMedicaFlag, P008Q4_A19CitaId, P008Q4_A332RecetaIndicaciones, P008Q4_A269RecetaMedicaCantidad, P008Q4_n269RecetaMedicaCantidad, P008Q4_A230MedicamentoNombre, P008Q4_A50RecetaMedicaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private byte A272RecetaMedicaFlag ;
   private short gxcookieaux ;
   private short AV26edad ;
   private short AV28EspecialidadId ;
   private short AV50SedeId ;
   private short A42MedicamentoId ;
   private short A269RecetaMedicaCantidad ;
   private short A50RecetaMedicaId ;
   private short Gx_err ;
   private int AV8CitaId ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int AV41PacienteId ;
   private int AV25DisponibilidadId ;
   private int AV47ProfesionalId ;
   private int A20PacienteId ;
   private int Gx_OldLine ;
   private int A23DiagnosticoId ;
   private int A19CitaId ;
   private int A22CitaDiagnosticoId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String A216PacienteSexo ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date AV24DisponibilidadHoraInicio ;
   private java.util.Date AV23DisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n42MedicamentoId ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n269RecetaMedicaCantidad ;
   private String AV13CitaInforme ;
   private String AV11CitaAntecedentes ;
   private String AV14CitaMotivoConsulta ;
   private String AV53TelefonoThani ;
   private String AV15CorreoThani ;
   private String AV21DireccionThani ;
   private String AV55TituloEpicrisis ;
   private String AV35PacienteApellidoPaterno ;
   private String AV34PacienteApellidoMaterno ;
   private String AV42PacienteNombres ;
   private String AV46PacienteTipoDocumento ;
   private String AV43PacienteNroDocumento ;
   private String AV40PacienteFechaNacimiento ;
   private String AV29EspecialidadNombre ;
   private String AV51SedeNombre ;
   private String AV48ProfesionalNombreCompleto ;
   private String AV12CitaCode ;
   private String AV54TipoConsulta ;
   private String AV36PacienteApeNom ;
   private String AV38PacienteDNI ;
   private String AV39PacienteEdad ;
   private String AV52SexoPaciente ;
   private String AV31MedicoNomAp ;
   private String AV30MedicoCOP ;
   private String A107DiagnosticoCodigo ;
   private String A108DiagnosticoDescripcion ;
   private String A332RecetaIndicaciones ;
   private String A230MedicamentoNombre ;
   private IDataStoreProvider pr_default ;
   private int[] P008Q2_A20PacienteId ;
   private String[] P008Q2_A216PacienteSexo ;
   private int[] P008Q3_A23DiagnosticoId ;
   private int[] P008Q3_A19CitaId ;
   private String[] P008Q3_A107DiagnosticoCodigo ;
   private String[] P008Q3_A108DiagnosticoDescripcion ;
   private int[] P008Q3_A22CitaDiagnosticoId ;
   private short[] P008Q4_A42MedicamentoId ;
   private boolean[] P008Q4_n42MedicamentoId ;
   private byte[] P008Q4_A272RecetaMedicaFlag ;
   private boolean[] P008Q4_n272RecetaMedicaFlag ;
   private int[] P008Q4_A19CitaId ;
   private String[] P008Q4_A332RecetaIndicaciones ;
   private short[] P008Q4_A269RecetaMedicaCantidad ;
   private boolean[] P008Q4_n269RecetaMedicaCantidad ;
   private String[] P008Q4_A230MedicamentoNombre ;
   private short[] P008Q4_A50RecetaMedicaId ;
   private com.projectthani.SdtProfesional AV9Profesional ;
   private com.projectthani.SdtCita AV10Cita ;
   private com.projectthani.SdtDisponibilidad AV22Disponibilidad ;
   private com.projectthani.SdtEspecialidad AV27Especialidad ;
   private com.projectthani.SdtPaciente AV33Paciente ;
   private com.projectthani.SdtSede AV49Sede ;
}

final  class aprcgenerarrecetamedica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008Q2", "SELECT [PacienteId], [PacienteSexo] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P008Q3", "SELECT T1.[DiagnosticoId], T1.[CitaId], T2.[DiagnosticoCodigo], T2.[DiagnosticoDescripcion], T1.[CitaDiagnosticoId] FROM ([CitaDiagnostico] T1 INNER JOIN [Diagnostico] T2 ON T2.[DiagnosticoId] = T1.[DiagnosticoId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008Q4", "SELECT T1.[MedicamentoId], T1.[RecetaMedicaFlag], T1.[CitaId], T1.[RecetaIndicaciones], T1.[RecetaMedicaCantidad], T2.[MedicamentoNombre], T1.[RecetaMedicaId] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId]) WHERE (T1.[CitaId] = ?) AND (T1.[RecetaMedicaFlag] = 1) ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

