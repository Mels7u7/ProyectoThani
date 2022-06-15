package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcenviarrecetamedica extends GXProcedure
{
   public prcenviarrecetamedica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcenviarrecetamedica.class ), "" );
   }

   public prcenviarrecetamedica( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      prcenviarrecetamedica.this.AV8CitaId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19CitaId = P007G2_A19CitaId[0] ;
         A64CitaCode = P007G2_A64CitaCode[0] ;
         A91CitaLink = P007G2_A91CitaLink[0] ;
         n91CitaLink = P007G2_n91CitaLink[0] ;
         A104PacienteApellidoMaterno = P007G2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P007G2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P007G2_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = P007G2_A106PacienteNroDocumento[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P007G2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P007G2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A20PacienteId = P007G2_A20PacienteId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P007G2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A21SGCitaDisponibilidadId = P007G2_A21SGCitaDisponibilidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P007G2_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P007G2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A99CitaMotivoConsulta = P007G2_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = P007G2_n99CitaMotivoConsulta[0] ;
         A86ProfesionalApellidoMaterno = P007G2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P007G2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P007G2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P007G2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P007G2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P007G2_n84ProfesionalNombres[0] ;
         A104PacienteApellidoMaterno = P007G2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P007G2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P007G2_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = P007G2_A106PacienteNroDocumento[0] ;
         A81SGCitaDisponibilidadProfesionalId = P007G2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A72SGCitaDisponibilidadSedeId = P007G2_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P007G2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A86ProfesionalApellidoMaterno = P007G2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P007G2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P007G2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P007G2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P007G2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P007G2_n84ProfesionalNombres[0] ;
         A73SGCitaDisponibilidadSedeNombre = P007G2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P007G2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         AV13CitaCode = A64CitaCode ;
         AV14CitaLink = A91CitaLink ;
         AV27PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         AV28PacienteApellidoPAterno = A103PacienteApellidoPaterno ;
         AV30Pacientenombres = A105PacienteNombres ;
         AV31PacienteNroDocumento = A106PacienteNroDocumento ;
         AV34ProfesionalNombreCompleto2 = A82SGCitaDisponibilidadProFullName ;
         AV24EspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
         AV36SedeNombre = A73SGCitaDisponibilidadSedeNombre ;
         AV29PacienteId = A20PacienteId ;
         AV33ProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         AV21DisponibilidadId = A21SGCitaDisponibilidadId ;
         AV35SedeId = A72SGCitaDisponibilidadSedeId ;
         AV23EspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         AV15CitaMotivoConsulta = A99CitaMotivoConsulta ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P007G3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV21DisponibilidadId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A34DisponibilidadId = P007G3_A34DisponibilidadId[0] ;
         A67DisponibilidadFecha = P007G3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P007G3_n67DisponibilidadFecha[0] ;
         A69DisponibilidadHoraInicio = P007G3_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P007G3_n69DisponibilidadHoraInicio[0] ;
         A298DisponibilidadTipoCita = P007G3_A298DisponibilidadTipoCita[0] ;
         AV19DisponibilidadFecha = A67DisponibilidadFecha ;
         AV20DisponibilidadHoraInicio = A69DisponibilidadHoraInicio ;
         AV22DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      /* Using cursor P007G4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV29PacienteId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A20PacienteId = P007G4_A20PacienteId[0] ;
         A217PacienteCorreo = P007G4_A217PacienteCorreo[0] ;
         A214PacienteTipoDocumento = P007G4_A214PacienteTipoDocumento[0] ;
         AV17CorreoPaciente = A217PacienteCorreo ;
         AV32PacienteTipoDocumento = A214PacienteTipoDocumento ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      /* Using cursor P007G5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV33ProfesionalId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A31ProfesionalId = P007G5_A31ProfesionalId[0] ;
         A179ProfesionalCorreo = P007G5_A179ProfesionalCorreo[0] ;
         AV16CorreoDoctor = A179ProfesionalCorreo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      /* Using cursor P007G6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV33ProfesionalId), Short.valueOf(AV23EspecialidadId), Short.valueOf(AV35SedeId), AV22DisponibilidadTipoCita});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A54SedeTipoConsulta = P007G6_A54SedeTipoConsulta[0] ;
         A30SedeId = P007G6_A30SedeId[0] ;
         A32EspecialidadId = P007G6_A32EspecialidadId[0] ;
         A31ProfesionalId = P007G6_A31ProfesionalId[0] ;
         A199CostoConsulta = P007G6_A199CostoConsulta[0] ;
         OV18CostoConsulta = AV18CostoConsulta ;
         AV18CostoConsulta = A199CostoConsulta ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(4);
      AV37subject = "Alertas Thani Salud - Receta Medica" ;
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
      AV9MailRecipient.setAddress( GXt_char1 );
      AV9MailRecipient.setName( "Alertas Thani Salud" );
      AV10SMTPSession.setHost( "mail.thanitech.pe" );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
      AV10SMTPSession.setUserName( GXt_char1 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
      prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
      AV10SMTPSession.setPassword( GXt_char1 );
      AV10SMTPSession.setPort( 465 );
      AV10SMTPSession.setSender( AV9MailRecipient );
      AV10SMTPSession.setAuthentication( (short)(1) );
      AV10SMTPSession.setSecure( (short)(1) );
      AV10SMTPSession.login();
      if ( GXutil.strcmp(AV10SMTPSession.getErrDescription(), "OK") == 0 )
      {
         AV25Log = (short)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV17CorreoPaciente)==0) )
      {
         AV26MailMsg.getTo().addNew("Usuario: ", AV17CorreoPaciente) ;
         AV26MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV26MailMsg.setSubject( AV37subject );
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "RecetaMedicaCorreo", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXt_char1 ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@URLRecetaMedica", "") ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcenviarrecetamedica.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         /* Using cursor P007G7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A19CitaId = P007G7_A19CitaId[0] ;
            A272RecetaMedicaFlag = P007G7_A272RecetaMedicaFlag[0] ;
            n272RecetaMedicaFlag = P007G7_n272RecetaMedicaFlag[0] ;
            A267RecetaMedicaNombreArchivo = P007G7_A267RecetaMedicaNombreArchivo[0] ;
            n267RecetaMedicaNombreArchivo = P007G7_n267RecetaMedicaNombreArchivo[0] ;
            A271RecetaArchivoTipo = P007G7_A271RecetaArchivoTipo[0] ;
            A270RecetaMedicaArchivo = P007G7_A270RecetaMedicaArchivo[0] ;
            n270RecetaMedicaArchivo = P007G7_n270RecetaMedicaArchivo[0] ;
            A50RecetaMedicaId = P007G7_A50RecetaMedicaId[0] ;
            AV26MailMsg.getAttachments().add(A270RecetaMedicaArchivo);
            pr_default.readNext(5);
         }
         pr_default.close(5);
         AV26MailMsg.setHtmltext( AV11TemplateContent );
         GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV26MailMsg.setDateSent( GXt_dtime3 );
         AV10SMTPSession.send(AV26MailMsg);
      }
      AV10SMTPSession.logout();
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P007G2_A19CitaId = new int[1] ;
      P007G2_A64CitaCode = new String[] {""} ;
      P007G2_A91CitaLink = new String[] {""} ;
      P007G2_n91CitaLink = new boolean[] {false} ;
      P007G2_A104PacienteApellidoMaterno = new String[] {""} ;
      P007G2_A103PacienteApellidoPaterno = new String[] {""} ;
      P007G2_A105PacienteNombres = new String[] {""} ;
      P007G2_A106PacienteNroDocumento = new String[] {""} ;
      P007G2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P007G2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P007G2_A20PacienteId = new int[1] ;
      P007G2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P007G2_A21SGCitaDisponibilidadId = new int[1] ;
      P007G2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P007G2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P007G2_A99CitaMotivoConsulta = new String[] {""} ;
      P007G2_n99CitaMotivoConsulta = new boolean[] {false} ;
      P007G2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P007G2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P007G2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P007G2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P007G2_A84ProfesionalNombres = new String[] {""} ;
      P007G2_n84ProfesionalNombres = new boolean[] {false} ;
      A64CitaCode = "" ;
      A91CitaLink = "" ;
      A104PacienteApellidoMaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A99CitaMotivoConsulta = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A84ProfesionalNombres = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      AV13CitaCode = "" ;
      AV14CitaLink = "" ;
      AV27PacienteApellidoMaterno = "" ;
      AV28PacienteApellidoPAterno = "" ;
      AV30Pacientenombres = "" ;
      AV31PacienteNroDocumento = "" ;
      AV34ProfesionalNombreCompleto2 = "" ;
      AV24EspecialidadNombre = "" ;
      AV36SedeNombre = "" ;
      AV15CitaMotivoConsulta = "" ;
      P007G3_A34DisponibilidadId = new int[1] ;
      P007G3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P007G3_n67DisponibilidadFecha = new boolean[] {false} ;
      P007G3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P007G3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P007G3_A298DisponibilidadTipoCita = new String[] {""} ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A298DisponibilidadTipoCita = "" ;
      AV19DisponibilidadFecha = GXutil.nullDate() ;
      AV20DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV22DisponibilidadTipoCita = "" ;
      P007G4_A20PacienteId = new int[1] ;
      P007G4_A217PacienteCorreo = new String[] {""} ;
      P007G4_A214PacienteTipoDocumento = new String[] {""} ;
      A217PacienteCorreo = "" ;
      A214PacienteTipoDocumento = "" ;
      AV17CorreoPaciente = "" ;
      AV32PacienteTipoDocumento = "" ;
      P007G5_A31ProfesionalId = new int[1] ;
      P007G5_A179ProfesionalCorreo = new String[] {""} ;
      A179ProfesionalCorreo = "" ;
      AV16CorreoDoctor = "" ;
      P007G6_A54SedeTipoConsulta = new String[] {""} ;
      P007G6_A30SedeId = new short[1] ;
      P007G6_A32EspecialidadId = new short[1] ;
      P007G6_A31ProfesionalId = new int[1] ;
      P007G6_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A54SedeTipoConsulta = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      OV18CostoConsulta = DecimalUtil.ZERO ;
      AV18CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      AV37subject = "" ;
      AV9MailRecipient = new com.genexus.internet.MailRecipient();
      AV10SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV26MailMsg = new com.genexus.internet.GXMailMessage();
      AV11TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      P007G7_A19CitaId = new int[1] ;
      P007G7_A272RecetaMedicaFlag = new byte[1] ;
      P007G7_n272RecetaMedicaFlag = new boolean[] {false} ;
      P007G7_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      P007G7_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      P007G7_A271RecetaArchivoTipo = new String[] {""} ;
      P007G7_A270RecetaMedicaArchivo = new String[] {""} ;
      P007G7_n270RecetaMedicaArchivo = new boolean[] {false} ;
      P007G7_A50RecetaMedicaId = new short[1] ;
      A267RecetaMedicaNombreArchivo = "" ;
      A271RecetaArchivoTipo = "" ;
      A270RecetaMedicaArchivo = "" ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcenviarrecetamedica__default(),
         new Object[] {
             new Object[] {
            P007G2_A19CitaId, P007G2_A64CitaCode, P007G2_A91CitaLink, P007G2_n91CitaLink, P007G2_A104PacienteApellidoMaterno, P007G2_A103PacienteApellidoPaterno, P007G2_A105PacienteNombres, P007G2_A106PacienteNroDocumento, P007G2_A146SGCitaDisponibilidadEspecialidadNombre, P007G2_A73SGCitaDisponibilidadSedeNombre,
            P007G2_A20PacienteId, P007G2_A81SGCitaDisponibilidadProfesionalId, P007G2_A21SGCitaDisponibilidadId, P007G2_A72SGCitaDisponibilidadSedeId, P007G2_A70SGCitaDisponibilidadEspecialidadId, P007G2_A99CitaMotivoConsulta, P007G2_n99CitaMotivoConsulta, P007G2_A86ProfesionalApellidoMaterno, P007G2_n86ProfesionalApellidoMaterno, P007G2_A85ProfesionalApellidoPaterno,
            P007G2_n85ProfesionalApellidoPaterno, P007G2_A84ProfesionalNombres, P007G2_n84ProfesionalNombres
            }
            , new Object[] {
            P007G3_A34DisponibilidadId, P007G3_A67DisponibilidadFecha, P007G3_n67DisponibilidadFecha, P007G3_A69DisponibilidadHoraInicio, P007G3_n69DisponibilidadHoraInicio, P007G3_A298DisponibilidadTipoCita
            }
            , new Object[] {
            P007G4_A20PacienteId, P007G4_A217PacienteCorreo, P007G4_A214PacienteTipoDocumento
            }
            , new Object[] {
            P007G5_A31ProfesionalId, P007G5_A179ProfesionalCorreo
            }
            , new Object[] {
            P007G6_A54SedeTipoConsulta, P007G6_A30SedeId, P007G6_A32EspecialidadId, P007G6_A31ProfesionalId, P007G6_A199CostoConsulta
            }
            , new Object[] {
            P007G7_A19CitaId, P007G7_A272RecetaMedicaFlag, P007G7_n272RecetaMedicaFlag, P007G7_A267RecetaMedicaNombreArchivo, P007G7_n267RecetaMedicaNombreArchivo, P007G7_A271RecetaArchivoTipo, P007G7_A270RecetaMedicaArchivo, P007G7_n270RecetaMedicaArchivo, P007G7_A50RecetaMedicaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A272RecetaMedicaFlag ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short AV35SedeId ;
   private short AV23EspecialidadId ;
   private short A30SedeId ;
   private short A32EspecialidadId ;
   private short AV25Log ;
   private short A50RecetaMedicaId ;
   private short Gx_err ;
   private int AV8CitaId ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV29PacienteId ;
   private int AV33ProfesionalId ;
   private int AV21DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal A199CostoConsulta ;
   private java.math.BigDecimal OV18CostoConsulta ;
   private java.math.BigDecimal AV18CostoConsulta ;
   private String scmdbuf ;
   private String A298DisponibilidadTipoCita ;
   private String AV22DisponibilidadTipoCita ;
   private String A214PacienteTipoDocumento ;
   private String AV32PacienteTipoDocumento ;
   private String A54SedeTipoConsulta ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date AV20DisponibilidadHoraInicio ;
   private java.util.Date GXt_dtime3 ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV19DisponibilidadFecha ;
   private boolean n91CitaLink ;
   private boolean n99CitaMotivoConsulta ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n84ProfesionalNombres ;
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n270RecetaMedicaArchivo ;
   private String A99CitaMotivoConsulta ;
   private String AV15CitaMotivoConsulta ;
   private String AV11TemplateContent ;
   private String A270RecetaMedicaArchivo ;
   private String A64CitaCode ;
   private String A91CitaLink ;
   private String A104PacienteApellidoMaterno ;
   private String A103PacienteApellidoPaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A84ProfesionalNombres ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String AV13CitaCode ;
   private String AV14CitaLink ;
   private String AV27PacienteApellidoMaterno ;
   private String AV28PacienteApellidoPAterno ;
   private String AV30Pacientenombres ;
   private String AV31PacienteNroDocumento ;
   private String AV34ProfesionalNombreCompleto2 ;
   private String AV24EspecialidadNombre ;
   private String AV36SedeNombre ;
   private String A217PacienteCorreo ;
   private String AV17CorreoPaciente ;
   private String A179ProfesionalCorreo ;
   private String AV16CorreoDoctor ;
   private String AV37subject ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private com.genexus.internet.MailRecipient AV9MailRecipient ;
   private com.genexus.internet.GXMailMessage AV26MailMsg ;
   private com.genexus.internet.GXSMTPSession AV10SMTPSession ;
   private IDataStoreProvider pr_default ;
   private int[] P007G2_A19CitaId ;
   private String[] P007G2_A64CitaCode ;
   private String[] P007G2_A91CitaLink ;
   private boolean[] P007G2_n91CitaLink ;
   private String[] P007G2_A104PacienteApellidoMaterno ;
   private String[] P007G2_A103PacienteApellidoPaterno ;
   private String[] P007G2_A105PacienteNombres ;
   private String[] P007G2_A106PacienteNroDocumento ;
   private String[] P007G2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P007G2_A73SGCitaDisponibilidadSedeNombre ;
   private int[] P007G2_A20PacienteId ;
   private int[] P007G2_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P007G2_A21SGCitaDisponibilidadId ;
   private short[] P007G2_A72SGCitaDisponibilidadSedeId ;
   private short[] P007G2_A70SGCitaDisponibilidadEspecialidadId ;
   private String[] P007G2_A99CitaMotivoConsulta ;
   private boolean[] P007G2_n99CitaMotivoConsulta ;
   private String[] P007G2_A86ProfesionalApellidoMaterno ;
   private boolean[] P007G2_n86ProfesionalApellidoMaterno ;
   private String[] P007G2_A85ProfesionalApellidoPaterno ;
   private boolean[] P007G2_n85ProfesionalApellidoPaterno ;
   private String[] P007G2_A84ProfesionalNombres ;
   private boolean[] P007G2_n84ProfesionalNombres ;
   private int[] P007G3_A34DisponibilidadId ;
   private java.util.Date[] P007G3_A67DisponibilidadFecha ;
   private boolean[] P007G3_n67DisponibilidadFecha ;
   private java.util.Date[] P007G3_A69DisponibilidadHoraInicio ;
   private boolean[] P007G3_n69DisponibilidadHoraInicio ;
   private String[] P007G3_A298DisponibilidadTipoCita ;
   private int[] P007G4_A20PacienteId ;
   private String[] P007G4_A217PacienteCorreo ;
   private String[] P007G4_A214PacienteTipoDocumento ;
   private int[] P007G5_A31ProfesionalId ;
   private String[] P007G5_A179ProfesionalCorreo ;
   private String[] P007G6_A54SedeTipoConsulta ;
   private short[] P007G6_A30SedeId ;
   private short[] P007G6_A32EspecialidadId ;
   private int[] P007G6_A31ProfesionalId ;
   private java.math.BigDecimal[] P007G6_A199CostoConsulta ;
   private int[] P007G7_A19CitaId ;
   private byte[] P007G7_A272RecetaMedicaFlag ;
   private boolean[] P007G7_n272RecetaMedicaFlag ;
   private String[] P007G7_A267RecetaMedicaNombreArchivo ;
   private boolean[] P007G7_n267RecetaMedicaNombreArchivo ;
   private String[] P007G7_A271RecetaArchivoTipo ;
   private String[] P007G7_A270RecetaMedicaArchivo ;
   private boolean[] P007G7_n270RecetaMedicaArchivo ;
   private short[] P007G7_A50RecetaMedicaId ;
}

final  class prcenviarrecetamedica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007G2", "SELECT T1.[CitaId], T1.[CitaCode], T1.[CitaLink], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNombres], T2.[PacienteNroDocumento], T6.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T1.[PacienteId], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T1.[CitaMotivoConsulta], T4.[ProfesionalApellidoMaterno], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalNombres] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Especialidad] T6 ON T6.[EspecialidadId] = T3.[EspecialidadId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007G3", "SELECT [DisponibilidadId], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadTipoCita] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007G4", "SELECT [PacienteId], [PacienteCorreo], [PacienteTipoDocumento] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007G5", "SELECT [ProfesionalId], [ProfesionalCorreo] FROM [Profesional] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007G6", "SELECT [SedeTipoConsulta], [SedeId], [EspecialidadId], [ProfesionalId], [CostoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? and [EspecialidadId] = ? and [SedeId] = ? and [SedeTipoConsulta] = ? ORDER BY [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007G7", "SELECT [CitaId], [RecetaMedicaFlag], [RecetaMedicaNombreArchivo], [RecetaArchivoTipo], [RecetaMedicaArchivo], [RecetaMedicaId] FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 0) ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((int[]) buf[12])[0] = rslt.getInt(12);
               ((short[]) buf[13])[0] = rslt.getShort(13);
               ((short[]) buf[14])[0] = rslt.getShort(14);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(15);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((String[]) buf[6])[0] = rslt.getBLOBFile(5, rslt.getVarchar(4), rslt.getVarchar(3));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
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
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

