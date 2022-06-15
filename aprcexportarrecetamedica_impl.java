package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aprcexportarrecetamedica_impl extends GXWebReport
{
   public aprcexportarrecetamedica_impl( com.genexus.internet.HttpContext context )
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
         AV46TituloEpicrisis = "Receta Medica" ;
         h7A0( false, 198) ;
         getPrinter().GxDrawBitMap(context.getHttpContext().getImagePath( "b1e5de41-0380-433f-b4a2-bd613143d5ec", "", context.getHttpContext().getTheme( )), 40, Gx_line+28, 267, Gx_line+113) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha:", 40, Gx_line+128, 113, Gx_line+142, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( AV21DisponibilidadFecha, "99/99/99"), 113, Gx_line+128, 240, Gx_line+143, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19diagtxt, "")), 393, Gx_line+99, 766, Gx_line+114, 0+16, 0, 0, 0) ;
         getPrinter().GxDrawText("Diagnostico: ", 200, Gx_line+170, 787, Gx_line+198, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("CIE 10: ", 40, Gx_line+170, 193, Gx_line+198, 1, 0, 0, 1) ;
         getPrinter().GxDrawRect(40, Gx_line+170, 780, Gx_line+198, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(193, Gx_line+170, 193, Gx_line+198, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Tipo Consulta:", 280, Gx_line+128, 367, Gx_line+142, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45TipoConsulta, "")), 367, Gx_line+128, 472, Gx_line+143, 0+256, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 16, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46TituloEpicrisis, "")), 320, Gx_line+43, 760, Gx_line+100, 0, 0, 0, 1) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+198) ;
         /* Using cursor P007A2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A23DiagnosticoId = P007A2_A23DiagnosticoId[0] ;
            A19CitaId = P007A2_A19CitaId[0] ;
            A107DiagnosticoCodigo = P007A2_A107DiagnosticoCodigo[0] ;
            A108DiagnosticoDescripcion = P007A2_A108DiagnosticoDescripcion[0] ;
            A22CitaDiagnosticoId = P007A2_A22CitaDiagnosticoId[0] ;
            A107DiagnosticoCodigo = P007A2_A107DiagnosticoCodigo[0] ;
            A108DiagnosticoDescripcion = P007A2_A108DiagnosticoDescripcion[0] ;
            h7A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A108DiagnosticoDescripcion, "")), 207, Gx_line+0, 767, Gx_line+18, 1+16, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A107DiagnosticoCodigo, "")), 53, Gx_line+0, 173, Gx_line+18, 1, 0, 0, 1) ;
            getPrinter().GxDrawLine(40, Gx_line+0, 40, Gx_line+20, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(193, Gx_line+0, 193, Gx_line+20, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(780, Gx_line+0, 780, Gx_line+20, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(40, Gx_line+20, 780, Gx_line+20, 1, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         h7A0( false, 50) ;
         getPrinter().GxDrawLine(240, Gx_line+22, 240, Gx_line+50, 1, 0, 0, 0, 0) ;
         getPrinter().GxDrawRect(40, Gx_line+22, 780, Gx_line+50, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medicamento", 40, Gx_line+22, 240, Gx_line+50, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("Indicaciones", 307, Gx_line+22, 787, Gx_line+50, 1, 0, 0, 1) ;
         getPrinter().GxDrawText("Cant.", 240, Gx_line+22, 300, Gx_line+50, 1, 0, 0, 1) ;
         getPrinter().GxDrawLine(307, Gx_line+22, 307, Gx_line+50, 1, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+50) ;
         /* Using cursor P007A3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A42MedicamentoId = P007A3_A42MedicamentoId[0] ;
            n42MedicamentoId = P007A3_n42MedicamentoId[0] ;
            A272RecetaMedicaFlag = P007A3_A272RecetaMedicaFlag[0] ;
            n272RecetaMedicaFlag = P007A3_n272RecetaMedicaFlag[0] ;
            A19CitaId = P007A3_A19CitaId[0] ;
            A332RecetaIndicaciones = P007A3_A332RecetaIndicaciones[0] ;
            A269RecetaMedicaCantidad = P007A3_A269RecetaMedicaCantidad[0] ;
            n269RecetaMedicaCantidad = P007A3_n269RecetaMedicaCantidad[0] ;
            A230MedicamentoNombre = P007A3_A230MedicamentoNombre[0] ;
            A50RecetaMedicaId = P007A3_A50RecetaMedicaId[0] ;
            A230MedicamentoNombre = P007A3_A230MedicamentoNombre[0] ;
            h7A0( false, 40) ;
            getPrinter().GxDrawLine(307, Gx_line+0, 307, Gx_line+40, 1, 0, 0, 0, 0) ;
            getPrinter().GxDrawRect(40, Gx_line+0, 780, Gx_line+40, 1, 0, 0, 0, 0, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(240, Gx_line+0, 240, Gx_line+40, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A230MedicamentoNombre, "")), 40, Gx_line+0, 233, Gx_line+40, 1, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9")), 242, Gx_line+0, 302, Gx_line+40, 1, 0, 0, 1) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A332RecetaIndicaciones, "")), 307, Gx_line+0, 787, Gx_line+40, 1, 0, 0, 1) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+40) ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         h7A0( false, 30) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("*Este documento ha sido generado automáticamente por la plataforma THANI", 42, Gx_line+13, 789, Gx_line+27, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+30) ;
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h7A0( true, 0) ;
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

   public void h7A0( boolean bFoot ,
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
   }

   public void add_metrics0( )
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
      P007A2_A23DiagnosticoId = new int[1] ;
      P007A2_A19CitaId = new int[1] ;
      P007A2_A107DiagnosticoCodigo = new String[] {""} ;
      P007A2_A108DiagnosticoDescripcion = new String[] {""} ;
      P007A2_A22CitaDiagnosticoId = new int[1] ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      P007A3_A42MedicamentoId = new short[1] ;
      P007A3_n42MedicamentoId = new boolean[] {false} ;
      P007A3_A272RecetaMedicaFlag = new byte[1] ;
      P007A3_n272RecetaMedicaFlag = new boolean[] {false} ;
      P007A3_A19CitaId = new int[1] ;
      P007A3_A332RecetaIndicaciones = new String[] {""} ;
      P007A3_A269RecetaMedicaCantidad = new short[1] ;
      P007A3_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P007A3_A230MedicamentoNombre = new String[] {""} ;
      P007A3_A50RecetaMedicaId = new short[1] ;
      A332RecetaIndicaciones = "" ;
      A230MedicamentoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.aprcexportarrecetamedica__default(),
         new Object[] {
             new Object[] {
            P007A2_A23DiagnosticoId, P007A2_A19CitaId, P007A2_A107DiagnosticoCodigo, P007A2_A108DiagnosticoDescripcion, P007A2_A22CitaDiagnosticoId
            }
            , new Object[] {
            P007A3_A42MedicamentoId, P007A3_n42MedicamentoId, P007A3_A272RecetaMedicaFlag, P007A3_n272RecetaMedicaFlag, P007A3_A19CitaId, P007A3_A332RecetaIndicaciones, P007A3_A269RecetaMedicaCantidad, P007A3_n269RecetaMedicaCantidad, P007A3_A230MedicamentoNombre, P007A3_A50RecetaMedicaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private byte A272RecetaMedicaFlag ;
   private short gxcookieaux ;
   private short AV24edad ;
   private short AV26EspecialidadId ;
   private short AV42SedeId ;
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
   private boolean n42MedicamentoId ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n269RecetaMedicaCantidad ;
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
   private String A332RecetaIndicaciones ;
   private String A230MedicamentoNombre ;
   private IDataStoreProvider pr_default ;
   private int[] P007A2_A23DiagnosticoId ;
   private int[] P007A2_A19CitaId ;
   private String[] P007A2_A107DiagnosticoCodigo ;
   private String[] P007A2_A108DiagnosticoDescripcion ;
   private int[] P007A2_A22CitaDiagnosticoId ;
   private short[] P007A3_A42MedicamentoId ;
   private boolean[] P007A3_n42MedicamentoId ;
   private byte[] P007A3_A272RecetaMedicaFlag ;
   private boolean[] P007A3_n272RecetaMedicaFlag ;
   private int[] P007A3_A19CitaId ;
   private String[] P007A3_A332RecetaIndicaciones ;
   private short[] P007A3_A269RecetaMedicaCantidad ;
   private boolean[] P007A3_n269RecetaMedicaCantidad ;
   private String[] P007A3_A230MedicamentoNombre ;
   private short[] P007A3_A50RecetaMedicaId ;
   private com.projectthani.SdtProfesional AV9Profesional ;
   private com.projectthani.SdtCita AV10Cita ;
   private com.projectthani.SdtDisponibilidad AV20Disponibilidad ;
   private com.projectthani.SdtEspecialidad AV25Especialidad ;
   private com.projectthani.SdtPaciente AV29Paciente ;
   private com.projectthani.SdtSede AV41Sede ;
}

final  class aprcexportarrecetamedica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007A2", "SELECT T1.[DiagnosticoId], T1.[CitaId], T2.[DiagnosticoCodigo], T2.[DiagnosticoDescripcion], T1.[CitaDiagnosticoId] FROM ([CitaDiagnostico] T1 INNER JOIN [Diagnostico] T2 ON T2.[DiagnosticoId] = T1.[DiagnosticoId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007A3", "SELECT T1.[MedicamentoId], T1.[RecetaMedicaFlag], T1.[CitaId], T1.[RecetaIndicaciones], T1.[RecetaMedicaCantidad], T2.[MedicamentoNombre], T1.[RecetaMedicaId] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId]) WHERE (T1.[CitaId] = ?) AND (T1.[RecetaMedicaFlag] = 1) ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
            case 1 :
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
      }
   }

}

