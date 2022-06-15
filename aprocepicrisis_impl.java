package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aprocepicrisis_impl extends GXWebReport
{
   public aprocepicrisis_impl( com.genexus.internet.HttpContext context )
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
         AV10Cita.Load(AV8CitaId);
         AV29Paciente.Load(AV10Cita.getgxTv_SdtCita_Pacienteid());
         AV34PacienteId = AV29Paciente.getgxTv_SdtPaciente_Pacienteid() ;
         AV31PacienteApellidoPaterno = AV10Cita.getgxTv_SdtCita_Pacienteapellidopaterno() ;
         AV30PacienteApellidoMaterno = AV10Cita.getgxTv_SdtCita_Pacienteapellidomaterno() ;
         AV35PacienteNombres = AV10Cita.getgxTv_SdtCita_Pacientenombres() ;
         if ( GXutil.strcmp(AV29Paciente.getgxTv_SdtPaciente_Pacientetipodocumento(), "1") == 0 )
         {
            AV38PacienteTipoDocumento = "DNI" ;
         }
         else
         {
            AV38PacienteTipoDocumento = "OTRO" ;
         }
         AV36PacienteNroDocumento = AV29Paciente.getgxTv_SdtPaciente_Pacientenrodocumento() ;
         GXt_dtime1 = GXutil.resetTime( AV29Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento() );
         AV24edad = (short)(GXutil.age( GXt_dtime1, GXutil.now( ))) ;
         AV33PacienteFechaNacimiento = localUtil.dtoc( AV29Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento(), 3, "/") + " (Edad: " + GXutil.str( AV24edad, 4, 0) + " años)" ;
         AV23DisponibilidadId = AV10Cita.getgxTv_SdtCita_Sgcitadisponibilidadid() ;
         AV20Disponibilidad.Load(AV23DisponibilidadId);
         AV26EspecialidadId = AV20Disponibilidad.getgxTv_SdtDisponibilidad_Especialidadid() ;
         AV25Especialidad.Load(AV26EspecialidadId);
         AV27EspecialidadNombre = AV25Especialidad.getgxTv_SdtEspecialidad_Especialidadcodigo() + " - " + AV25Especialidad.getgxTv_SdtEspecialidad_Especialidadnombre() ;
         AV42SedeId = AV20Disponibilidad.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid() ;
         AV41Sede.Load(AV42SedeId);
         AV43SedeNombre = AV41Sede.getgxTv_SdtSede_Sedenombre() + " / " + AV41Sede.getgxTv_SdtSede_Clinicanombrecomercial() ;
         AV39ProfesionalId = AV20Disponibilidad.getgxTv_SdtDisponibilidad_Profesionalid() ;
         AV9Profesional.Load(AV39ProfesionalId);
         AV40ProfesionalNombreCompleto = AV9Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() + " " + AV9Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno() + ", " + AV9Profesional.getgxTv_SdtProfesional_Profesionalnombres() + " - CMP:" + AV9Profesional.getgxTv_SdtProfesional_Profesionalcop() ;
         AV21DisponibilidadFecha = AV20Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha() ;
         AV22DisponibilidadHoraInicio = AV20Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio() ;
         AV13CitaInforme = AV10Cita.getgxTv_SdtCita_Citainforme() ;
         AV11CitaAntecedentes = AV10Cita.getgxTv_SdtCita_Citaantecedentes() ;
         AV14CitaMotivoConsulta = AV10Cita.getgxTv_SdtCita_Citamotivoconsulta() ;
         AV12CitaCode = AV10Cita.getgxTv_SdtCita_Citacode() ;
         AV45TipoConsulta = com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)AV20Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadtipocita()) ;
         AV46TituloEpicrisis = "Epicrisis con código " + AV12CitaCode ;
         h6S0( false, 190) ;
         getPrinter().GxDrawBitMap(context.getHttpContext().getImagePath( "62fabb4b-713d-4bd3-9f52-cde8b0a8f851", "", context.getHttpContext().getTheme( )), 42, Gx_line+50, 244, Gx_line+107) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha:", 40, Gx_line+133, 115, Gx_line+147, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV21DisponibilidadFecha, "99/99/99"), 113, Gx_line+131, 240, Gx_line+146, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( AV22DisponibilidadHoraInicio, "99:99"), 600, Gx_line+131, 773, Gx_line+146, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19diagtxt, "")), 392, Gx_line+100, 767, Gx_line+115, 0+16, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 10, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Diagnostico: ", 200, Gx_line+167, 783, Gx_line+190, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("CIE 10: ", 42, Gx_line+167, 192, Gx_line+190, 1, 0, 0, 1) ;
         getPrinter().GxDrawRect(42, Gx_line+167, 784, Gx_line+190, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(192, Gx_line+167, 192, Gx_line+190, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Consulta:", 280, Gx_line+133, 363, Gx_line+147, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Hora de Inicio:", 513, Gx_line+133, 596, Gx_line+147, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45TipoConsulta, "")), 367, Gx_line+131, 472, Gx_line+146, 0+256, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 15, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46TituloEpicrisis, "")), 317, Gx_line+50, 775, Gx_line+103, 0, 0, 0, 1) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+190) ;
         /* Using cursor P006S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A23DiagnosticoId = P006S2_A23DiagnosticoId[0] ;
            A19CitaId = P006S2_A19CitaId[0] ;
            A107DiagnosticoCodigo = P006S2_A107DiagnosticoCodigo[0] ;
            A108DiagnosticoDescripcion = P006S2_A108DiagnosticoDescripcion[0] ;
            A22CitaDiagnosticoId = P006S2_A22CitaDiagnosticoId[0] ;
            A107DiagnosticoCodigo = P006S2_A107DiagnosticoCodigo[0] ;
            A108DiagnosticoDescripcion = P006S2_A108DiagnosticoDescripcion[0] ;
            h6S0( false, 18) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A108DiagnosticoDescripcion, "")), 208, Gx_line+0, 766, Gx_line+17, 1+16, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A107DiagnosticoCodigo, "")), 50, Gx_line+0, 167, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(42, Gx_line+0, 42, Gx_line+17, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(192, Gx_line+0, 192, Gx_line+17, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(784, Gx_line+0, 784, Gx_line+17, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(42, Gx_line+17, 784, Gx_line+17, 1, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+18) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         h6S0( false, 729) ;
         getPrinter().GxDrawLine(42, Gx_line+183, 784, Gx_line+183, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+533, 784, Gx_line+533, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+417, 784, Gx_line+417, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+317, 784, Gx_line+317, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+283, 784, Gx_line+283, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+250, 784, Gx_line+250, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(217, Gx_line+217, 217, Gx_line+667, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+183, 42, Gx_line+216, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(784, Gx_line+183, 784, Gx_line+216, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(AV14CitaMotivoConsulta, 233, Gx_line+333, 766, Gx_line+400, 0+16, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Motivo Consulta:", 67, Gx_line+333, 200, Gx_line+347, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(AV13CitaInforme, 233, Gx_line+550, 766, Gx_line+650, 0+16, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Historia Médica Actual: ", 67, Gx_line+550, 200, Gx_line+564, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(AV11CitaAntecedentes, 233, Gx_line+433, 766, Gx_line+516, 0+16, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Antecedentes: ", 67, Gx_line+433, 200, Gx_line+447, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("*Este documento ha sido generado automáticamente por la plataforma THANI", 58, Gx_line+700, 805, Gx_line+714, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43SedeNombre, "")), 233, Gx_line+283, 651, Gx_line+315, 0, 0, 0, 1) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27EspecialidadNombre, "")), 233, Gx_line+250, 442, Gx_line+282, 0, 0, 0, 1) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40ProfesionalNombreCompleto, "")), 233, Gx_line+217, 755, Gx_line+249, 0, 0, 0, 1) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Profesional: ", 67, Gx_line+217, 200, Gx_line+248, 0, 0, 0, 1) ;
         getPrinter().GxDrawText("Especialidad:", 67, Gx_line+250, 200, Gx_line+281, 0, 0, 0, 1) ;
         getPrinter().GxDrawText("Sede:", 67, Gx_line+283, 200, Gx_line+314, 0, 0, 0, 1) ;
         getPrinter().GxDrawRect(42, Gx_line+217, 784, Gx_line+667, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 10, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Información de la Cita", 50, Gx_line+183, 243, Gx_line+217, 0, 0, 0, 1) ;
         getPrinter().GxDrawLine(42, Gx_line+17, 784, Gx_line+17, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(42, Gx_line+17, 42, Gx_line+50, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(784, Gx_line+17, 784, Gx_line+50, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33PacienteFechaNacimiento, "")), 617, Gx_line+67, 759, Gx_line+82, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha de Nacimiento: ", 492, Gx_line+67, 616, Gx_line+81, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Tipo de Documento:", 492, Gx_line+100, 616, Gx_line+114, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Nro de Documento:", 492, Gx_line+133, 616, Gx_line+147, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36PacienteNroDocumento, "")), 617, Gx_line+133, 757, Gx_line+148, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38PacienteTipoDocumento, "")), 617, Gx_line+100, 757, Gx_line+115, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35PacienteNombres, "")), 175, Gx_line+133, 449, Gx_line+148, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30PacienteApellidoMaterno, "")), 175, Gx_line+100, 449, Gx_line+115, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31PacienteApellidoPaterno, "")), 175, Gx_line+67, 449, Gx_line+82, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombres: ", 67, Gx_line+133, 168, Gx_line+147, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Apellido Paterno: ", 67, Gx_line+67, 168, Gx_line+81, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Apellido Materno: ", 67, Gx_line+100, 168, Gx_line+114, 0, 0, 0, 0) ;
         getPrinter().GxDrawRect(42, Gx_line+50, 784, Gx_line+167, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 10, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Información del Paciente", 50, Gx_line+17, 233, Gx_line+50, 0, 0, 0, 1) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+729) ;
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h6S0( true, 0) ;
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

   public void h6S0( boolean bFoot ,
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
      getPrinter().setMetrics("Microsoft Sans Serif", true, false, 57, 15, 72, 163,  new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 19, 29, 34, 34, 55, 45, 15, 21, 21, 24, 36, 17, 21, 17, 17, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 21, 21, 36, 36, 36, 38, 60, 43, 45, 45, 45, 41, 38, 48, 45, 17, 34, 45, 38, 53, 45, 48, 41, 48, 45, 41, 38, 45, 41, 57, 41, 41, 38, 21, 17, 21, 36, 34, 21, 34, 38, 34, 38, 34, 21, 38, 38, 17, 17, 34, 17, 55, 38, 38, 38, 38, 24, 34, 21, 38, 33, 49, 34, 34, 31, 24, 17, 24, 36, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 21, 34, 34, 34, 34, 17, 34, 21, 46, 23, 34, 36, 21, 46, 34, 25, 34, 21, 21, 21, 36, 34, 21, 20, 21, 23, 34, 52, 52, 52, 38, 45, 45, 45, 45, 45, 45, 62, 45, 41, 41, 41, 41, 17, 17, 17, 17, 45, 45, 48, 48, 48, 48, 48, 36, 48, 45, 45, 45, 45, 41, 41, 38, 34, 34, 34, 34, 34, 34, 55, 34, 34, 34, 34, 34, 17, 17, 17, 17, 38, 38, 38, 38, 38, 38, 38, 34, 38, 38, 38, 38, 38, 34, 38, 34}) ;
   }

   public void add_metrics1( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
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
      AV10Cita = new com.projectthani.SdtCita(remoteHandle);
      AV29Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV31PacienteApellidoPaterno = "" ;
      AV30PacienteApellidoMaterno = "" ;
      AV35PacienteNombres = "" ;
      AV38PacienteTipoDocumento = "" ;
      AV36PacienteNroDocumento = "" ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      AV33PacienteFechaNacimiento = "" ;
      AV20Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV25Especialidad = new com.projectthani.SdtEspecialidad(remoteHandle);
      AV27EspecialidadNombre = "" ;
      AV41Sede = new com.projectthani.SdtSede(remoteHandle);
      AV43SedeNombre = "" ;
      AV9Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV40ProfesionalNombreCompleto = "" ;
      AV21DisponibilidadFecha = GXutil.nullDate() ;
      AV22DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV13CitaInforme = "" ;
      AV11CitaAntecedentes = "" ;
      AV14CitaMotivoConsulta = "" ;
      AV12CitaCode = "" ;
      AV45TipoConsulta = "" ;
      AV46TituloEpicrisis = "" ;
      AV19diagtxt = "" ;
      scmdbuf = "" ;
      P006S2_A23DiagnosticoId = new int[1] ;
      P006S2_A19CitaId = new int[1] ;
      P006S2_A107DiagnosticoCodigo = new String[] {""} ;
      P006S2_A108DiagnosticoDescripcion = new String[] {""} ;
      P006S2_A22CitaDiagnosticoId = new int[1] ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.aprocepicrisis__default(),
         new Object[] {
             new Object[] {
            P006S2_A23DiagnosticoId, P006S2_A19CitaId, P006S2_A107DiagnosticoCodigo, P006S2_A108DiagnosticoDescripcion, P006S2_A22CitaDiagnosticoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV24edad ;
   private short AV26EspecialidadId ;
   private short AV42SedeId ;
   private short Gx_err ;
   private int AV8CitaId ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int AV34PacienteId ;
   private int AV23DisponibilidadId ;
   private int AV39ProfesionalId ;
   private int Gx_OldLine ;
   private int A23DiagnosticoId ;
   private int A19CitaId ;
   private int A22CitaDiagnosticoId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date AV22DisponibilidadHoraInicio ;
   private java.util.Date AV21DisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private String AV13CitaInforme ;
   private String AV11CitaAntecedentes ;
   private String AV14CitaMotivoConsulta ;
   private String AV31PacienteApellidoPaterno ;
   private String AV30PacienteApellidoMaterno ;
   private String AV35PacienteNombres ;
   private String AV38PacienteTipoDocumento ;
   private String AV36PacienteNroDocumento ;
   private String AV33PacienteFechaNacimiento ;
   private String AV27EspecialidadNombre ;
   private String AV43SedeNombre ;
   private String AV40ProfesionalNombreCompleto ;
   private String AV12CitaCode ;
   private String AV45TipoConsulta ;
   private String AV46TituloEpicrisis ;
   private String AV19diagtxt ;
   private String A107DiagnosticoCodigo ;
   private String A108DiagnosticoDescripcion ;
   private IDataStoreProvider pr_default ;
   private int[] P006S2_A23DiagnosticoId ;
   private int[] P006S2_A19CitaId ;
   private String[] P006S2_A107DiagnosticoCodigo ;
   private String[] P006S2_A108DiagnosticoDescripcion ;
   private int[] P006S2_A22CitaDiagnosticoId ;
   private com.projectthani.SdtProfesional AV9Profesional ;
   private com.projectthani.SdtCita AV10Cita ;
   private com.projectthani.SdtDisponibilidad AV20Disponibilidad ;
   private com.projectthani.SdtEspecialidad AV25Especialidad ;
   private com.projectthani.SdtPaciente AV29Paciente ;
   private com.projectthani.SdtSede AV41Sede ;
}

final  class aprocepicrisis__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006S2", "SELECT T1.[DiagnosticoId], T1.[CitaId], T2.[DiagnosticoCodigo], T2.[DiagnosticoDescripcion], T1.[CitaDiagnosticoId] FROM ([CitaDiagnostico] T1 INNER JOIN [Diagnostico] T2 ON T2.[DiagnosticoId] = T1.[DiagnosticoId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
      }
   }

}

