package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinformecitacorreo extends GXProcedure
{
   public prcinformecitacorreo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinformecitacorreo.class ), "" );
   }

   public prcinformecitacorreo( int remoteHandle ,
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
      prcinformecitacorreo.this.AV8CitaId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19CitaId = P006T2_A19CitaId[0] ;
         A64CitaCode = P006T2_A64CitaCode[0] ;
         A91CitaLink = P006T2_A91CitaLink[0] ;
         n91CitaLink = P006T2_n91CitaLink[0] ;
         A104PacienteApellidoMaterno = P006T2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006T2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P006T2_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = P006T2_A106PacienteNroDocumento[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P006T2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P006T2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A20PacienteId = P006T2_A20PacienteId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P006T2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A21SGCitaDisponibilidadId = P006T2_A21SGCitaDisponibilidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P006T2_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P006T2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A99CitaMotivoConsulta = P006T2_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = P006T2_n99CitaMotivoConsulta[0] ;
         A86ProfesionalApellidoMaterno = P006T2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P006T2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P006T2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P006T2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P006T2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P006T2_n84ProfesionalNombres[0] ;
         A104PacienteApellidoMaterno = P006T2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006T2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P006T2_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = P006T2_A106PacienteNroDocumento[0] ;
         A81SGCitaDisponibilidadProfesionalId = P006T2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A72SGCitaDisponibilidadSedeId = P006T2_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P006T2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A86ProfesionalApellidoMaterno = P006T2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P006T2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P006T2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P006T2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P006T2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P006T2_n84ProfesionalNombres[0] ;
         A73SGCitaDisponibilidadSedeNombre = P006T2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P006T2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         AV12CitaCode = A64CitaCode ;
         AV13CitaLink = A91CitaLink ;
         AV26PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         AV27PacienteApellidoPAterno = A103PacienteApellidoPaterno ;
         AV29Pacientenombres = A105PacienteNombres ;
         AV30PacienteNroDocumento = A106PacienteNroDocumento ;
         AV33ProfesionalNombreCompleto2 = A82SGCitaDisponibilidadProFullName ;
         AV23EspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
         AV35SedeNombre = A73SGCitaDisponibilidadSedeNombre ;
         AV28PacienteId = A20PacienteId ;
         AV32ProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         AV20DisponibilidadId = A21SGCitaDisponibilidadId ;
         AV34SedeId = A72SGCitaDisponibilidadSedeId ;
         AV22EspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         AV14CitaMotivoConsulta = A99CitaMotivoConsulta ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P006T3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV20DisponibilidadId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A34DisponibilidadId = P006T3_A34DisponibilidadId[0] ;
         A67DisponibilidadFecha = P006T3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P006T3_n67DisponibilidadFecha[0] ;
         A69DisponibilidadHoraInicio = P006T3_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P006T3_n69DisponibilidadHoraInicio[0] ;
         A298DisponibilidadTipoCita = P006T3_A298DisponibilidadTipoCita[0] ;
         AV18DisponibilidadFecha = A67DisponibilidadFecha ;
         AV19DisponibilidadHoraInicio = A69DisponibilidadHoraInicio ;
         AV21DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      /* Using cursor P006T4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV28PacienteId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A20PacienteId = P006T4_A20PacienteId[0] ;
         A217PacienteCorreo = P006T4_A217PacienteCorreo[0] ;
         A214PacienteTipoDocumento = P006T4_A214PacienteTipoDocumento[0] ;
         AV16CorreoPaciente = A217PacienteCorreo ;
         AV31PacienteTipoDocumento = A214PacienteTipoDocumento ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      /* Using cursor P006T5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV32ProfesionalId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A31ProfesionalId = P006T5_A31ProfesionalId[0] ;
         A179ProfesionalCorreo = P006T5_A179ProfesionalCorreo[0] ;
         AV15CorreoDoctor = A179ProfesionalCorreo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      /* Using cursor P006T6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV32ProfesionalId), Short.valueOf(AV22EspecialidadId), Short.valueOf(AV34SedeId), AV21DisponibilidadTipoCita});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A54SedeTipoConsulta = P006T6_A54SedeTipoConsulta[0] ;
         A30SedeId = P006T6_A30SedeId[0] ;
         A32EspecialidadId = P006T6_A32EspecialidadId[0] ;
         A31ProfesionalId = P006T6_A31ProfesionalId[0] ;
         A199CostoConsulta = P006T6_A199CostoConsulta[0] ;
         OV17CostoConsulta = AV17CostoConsulta ;
         AV17CostoConsulta = A199CostoConsulta ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(4);
      GXt_char1 = AV37LinkCitaPaciente ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "ThaniMainUrl", GXv_char2) ;
      prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
      AV37LinkCitaPaciente = GXt_char1 + formatLink("com.projectthani.wpvideollamadapaciente", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CitaId,8,0))}, new String[] {"CitaId"})  ;
      AV36subject = "Alertas Thani Salud - Informe cita" ;
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
      AV9MailRecipient.setAddress( GXt_char1 );
      AV9MailRecipient.setName( "Alertas Thani Salud" );
      AV10SMTPSession.setHost( "mail.thanitech.pe" );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
      AV10SMTPSession.setUserName( GXt_char1 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
      prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
      AV10SMTPSession.setPassword( GXt_char1 );
      AV10SMTPSession.setPort( 465 );
      AV10SMTPSession.setSender( AV9MailRecipient );
      AV10SMTPSession.setAuthentication( (short)(1) );
      AV10SMTPSession.setSecure( (short)(1) );
      AV10SMTPSession.login();
      if ( GXutil.strcmp(AV10SMTPSession.getErrDescription(), "OK") == 0 )
      {
         AV24Log = (short)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV15CorreoDoctor)==0) )
      {
         AV25MailMsg.getTo().addNew("Usuario: ", AV15CorreoDoctor) ;
         AV25MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV25MailMsg.setSubject( AV36subject );
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "InformeCitaCorreo", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXt_char1 ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@CodigoCita", AV12CitaCode) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@PacienteApellidos", AV27PacienteApellidoPAterno+"  "+AV26PacienteApellidoMaterno) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@PacienteNombres", AV29Pacientenombres) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@TipoDocPaciente", com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV31PacienteTipoDocumento)) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@NroDocPaciente", AV30PacienteNroDocumento) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@NombreCompletoProfesional", AV33ProfesionalNombreCompleto2) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@EspecialidadProfesional", AV23EspecialidadNombre) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@SedeProfesional", AV35SedeNombre) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@TipoConsultaCita", com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)AV21DisponibilidadTipoCita)) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@FechaCita", localUtil.dtoc( AV18DisponibilidadFecha, 3, "/")) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@HoraCita", localUtil.ttoc( AV19DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@MontoCita", GXutil.trim( GXutil.str( AV17CostoConsulta, 6, 2))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@MotivoConsulta", AV14CitaMotivoConsulta) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@UrlVideollamada", AV13CitaLink) ;
         AV25MailMsg.setHtmltext( AV11TemplateContent );
         GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV25MailMsg.setDateSent( GXt_dtime3 );
         AV10SMTPSession.send(AV25MailMsg);
      }
      AV25MailMsg.getTo().removeAllItems();
      if ( ! (GXutil.strcmp("", AV16CorreoPaciente)==0) )
      {
         AV25MailMsg.getTo().addNew("Usuario: ", AV16CorreoPaciente) ;
         AV25MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV25MailMsg.setSubject( AV36subject );
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "InformeCitaCorreo", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXt_char1 ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@CodigoCita", AV12CitaCode) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@PacienteApellidos", AV27PacienteApellidoPAterno) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@PacienteNombres", AV29Pacientenombres) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@TipoDocPaciente", com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV31PacienteTipoDocumento)) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@NroDocPaciente", AV30PacienteNroDocumento) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@NombreCompletoProfesional", AV33ProfesionalNombreCompleto2) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@EspecialidadProfesional", AV23EspecialidadNombre) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@SedeProfesional", AV35SedeNombre) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@TipoConsultaCita", com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)AV21DisponibilidadTipoCita)) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@FechaCita", localUtil.dtoc( AV18DisponibilidadFecha, 3, "/")) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@HoraCita", localUtil.ttoc( AV19DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@MontoCita", GXutil.trim( GXutil.str( AV17CostoConsulta, 6, 2))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@MotivoConsulta", AV14CitaMotivoConsulta) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV11TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcinformecitacorreo.this.GXt_char1 = GXv_char2[0] ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         AV11TemplateContent = GXutil.strReplace( AV11TemplateContent, "@UrlVideollamada", AV37LinkCitaPaciente) ;
         AV25MailMsg.setHtmltext( AV11TemplateContent );
         GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV25MailMsg.setDateSent( GXt_dtime3 );
         AV10SMTPSession.send(AV25MailMsg);
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
      P006T2_A19CitaId = new int[1] ;
      P006T2_A64CitaCode = new String[] {""} ;
      P006T2_A91CitaLink = new String[] {""} ;
      P006T2_n91CitaLink = new boolean[] {false} ;
      P006T2_A104PacienteApellidoMaterno = new String[] {""} ;
      P006T2_A103PacienteApellidoPaterno = new String[] {""} ;
      P006T2_A105PacienteNombres = new String[] {""} ;
      P006T2_A106PacienteNroDocumento = new String[] {""} ;
      P006T2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P006T2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P006T2_A20PacienteId = new int[1] ;
      P006T2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P006T2_A21SGCitaDisponibilidadId = new int[1] ;
      P006T2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P006T2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P006T2_A99CitaMotivoConsulta = new String[] {""} ;
      P006T2_n99CitaMotivoConsulta = new boolean[] {false} ;
      P006T2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P006T2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P006T2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P006T2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P006T2_A84ProfesionalNombres = new String[] {""} ;
      P006T2_n84ProfesionalNombres = new boolean[] {false} ;
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
      AV12CitaCode = "" ;
      AV13CitaLink = "" ;
      AV26PacienteApellidoMaterno = "" ;
      AV27PacienteApellidoPAterno = "" ;
      AV29Pacientenombres = "" ;
      AV30PacienteNroDocumento = "" ;
      AV33ProfesionalNombreCompleto2 = "" ;
      AV23EspecialidadNombre = "" ;
      AV35SedeNombre = "" ;
      AV14CitaMotivoConsulta = "" ;
      P006T3_A34DisponibilidadId = new int[1] ;
      P006T3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006T3_n67DisponibilidadFecha = new boolean[] {false} ;
      P006T3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P006T3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P006T3_A298DisponibilidadTipoCita = new String[] {""} ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A298DisponibilidadTipoCita = "" ;
      AV18DisponibilidadFecha = GXutil.nullDate() ;
      AV19DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV21DisponibilidadTipoCita = "" ;
      P006T4_A20PacienteId = new int[1] ;
      P006T4_A217PacienteCorreo = new String[] {""} ;
      P006T4_A214PacienteTipoDocumento = new String[] {""} ;
      A217PacienteCorreo = "" ;
      A214PacienteTipoDocumento = "" ;
      AV16CorreoPaciente = "" ;
      AV31PacienteTipoDocumento = "" ;
      P006T5_A31ProfesionalId = new int[1] ;
      P006T5_A179ProfesionalCorreo = new String[] {""} ;
      A179ProfesionalCorreo = "" ;
      AV15CorreoDoctor = "" ;
      P006T6_A54SedeTipoConsulta = new String[] {""} ;
      P006T6_A30SedeId = new short[1] ;
      P006T6_A32EspecialidadId = new short[1] ;
      P006T6_A31ProfesionalId = new int[1] ;
      P006T6_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A54SedeTipoConsulta = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      OV17CostoConsulta = DecimalUtil.ZERO ;
      AV17CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      AV37LinkCitaPaciente = "" ;
      AV36subject = "" ;
      AV9MailRecipient = new com.genexus.internet.MailRecipient();
      AV10SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV25MailMsg = new com.genexus.internet.GXMailMessage();
      AV11TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinformecitacorreo__default(),
         new Object[] {
             new Object[] {
            P006T2_A19CitaId, P006T2_A64CitaCode, P006T2_A91CitaLink, P006T2_n91CitaLink, P006T2_A104PacienteApellidoMaterno, P006T2_A103PacienteApellidoPaterno, P006T2_A105PacienteNombres, P006T2_A106PacienteNroDocumento, P006T2_A146SGCitaDisponibilidadEspecialidadNombre, P006T2_A73SGCitaDisponibilidadSedeNombre,
            P006T2_A20PacienteId, P006T2_A81SGCitaDisponibilidadProfesionalId, P006T2_A21SGCitaDisponibilidadId, P006T2_A72SGCitaDisponibilidadSedeId, P006T2_A70SGCitaDisponibilidadEspecialidadId, P006T2_A99CitaMotivoConsulta, P006T2_n99CitaMotivoConsulta, P006T2_A86ProfesionalApellidoMaterno, P006T2_n86ProfesionalApellidoMaterno, P006T2_A85ProfesionalApellidoPaterno,
            P006T2_n85ProfesionalApellidoPaterno, P006T2_A84ProfesionalNombres, P006T2_n84ProfesionalNombres
            }
            , new Object[] {
            P006T3_A34DisponibilidadId, P006T3_A67DisponibilidadFecha, P006T3_n67DisponibilidadFecha, P006T3_A69DisponibilidadHoraInicio, P006T3_n69DisponibilidadHoraInicio, P006T3_A298DisponibilidadTipoCita
            }
            , new Object[] {
            P006T4_A20PacienteId, P006T4_A217PacienteCorreo, P006T4_A214PacienteTipoDocumento
            }
            , new Object[] {
            P006T5_A31ProfesionalId, P006T5_A179ProfesionalCorreo
            }
            , new Object[] {
            P006T6_A54SedeTipoConsulta, P006T6_A30SedeId, P006T6_A32EspecialidadId, P006T6_A31ProfesionalId, P006T6_A199CostoConsulta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A72SGCitaDisponibilidadSedeId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short AV34SedeId ;
   private short AV22EspecialidadId ;
   private short A30SedeId ;
   private short A32EspecialidadId ;
   private short AV24Log ;
   private short Gx_err ;
   private int AV8CitaId ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV28PacienteId ;
   private int AV32ProfesionalId ;
   private int AV20DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal A199CostoConsulta ;
   private java.math.BigDecimal OV17CostoConsulta ;
   private java.math.BigDecimal AV17CostoConsulta ;
   private String scmdbuf ;
   private String A298DisponibilidadTipoCita ;
   private String AV21DisponibilidadTipoCita ;
   private String A214PacienteTipoDocumento ;
   private String AV31PacienteTipoDocumento ;
   private String A54SedeTipoConsulta ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date AV19DisponibilidadHoraInicio ;
   private java.util.Date GXt_dtime3 ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV18DisponibilidadFecha ;
   private boolean n91CitaLink ;
   private boolean n99CitaMotivoConsulta ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n84ProfesionalNombres ;
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private String A99CitaMotivoConsulta ;
   private String AV11TemplateContent ;
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
   private String AV12CitaCode ;
   private String AV13CitaLink ;
   private String AV26PacienteApellidoMaterno ;
   private String AV27PacienteApellidoPAterno ;
   private String AV29Pacientenombres ;
   private String AV30PacienteNroDocumento ;
   private String AV33ProfesionalNombreCompleto2 ;
   private String AV23EspecialidadNombre ;
   private String AV35SedeNombre ;
   private String AV14CitaMotivoConsulta ;
   private String A217PacienteCorreo ;
   private String AV16CorreoPaciente ;
   private String A179ProfesionalCorreo ;
   private String AV15CorreoDoctor ;
   private String AV37LinkCitaPaciente ;
   private String AV36subject ;
   private com.genexus.internet.MailRecipient AV9MailRecipient ;
   private com.genexus.internet.GXMailMessage AV25MailMsg ;
   private com.genexus.internet.GXSMTPSession AV10SMTPSession ;
   private IDataStoreProvider pr_default ;
   private int[] P006T2_A19CitaId ;
   private String[] P006T2_A64CitaCode ;
   private String[] P006T2_A91CitaLink ;
   private boolean[] P006T2_n91CitaLink ;
   private String[] P006T2_A104PacienteApellidoMaterno ;
   private String[] P006T2_A103PacienteApellidoPaterno ;
   private String[] P006T2_A105PacienteNombres ;
   private String[] P006T2_A106PacienteNroDocumento ;
   private String[] P006T2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P006T2_A73SGCitaDisponibilidadSedeNombre ;
   private int[] P006T2_A20PacienteId ;
   private int[] P006T2_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P006T2_A21SGCitaDisponibilidadId ;
   private short[] P006T2_A72SGCitaDisponibilidadSedeId ;
   private short[] P006T2_A70SGCitaDisponibilidadEspecialidadId ;
   private String[] P006T2_A99CitaMotivoConsulta ;
   private boolean[] P006T2_n99CitaMotivoConsulta ;
   private String[] P006T2_A86ProfesionalApellidoMaterno ;
   private boolean[] P006T2_n86ProfesionalApellidoMaterno ;
   private String[] P006T2_A85ProfesionalApellidoPaterno ;
   private boolean[] P006T2_n85ProfesionalApellidoPaterno ;
   private String[] P006T2_A84ProfesionalNombres ;
   private boolean[] P006T2_n84ProfesionalNombres ;
   private int[] P006T3_A34DisponibilidadId ;
   private java.util.Date[] P006T3_A67DisponibilidadFecha ;
   private boolean[] P006T3_n67DisponibilidadFecha ;
   private java.util.Date[] P006T3_A69DisponibilidadHoraInicio ;
   private boolean[] P006T3_n69DisponibilidadHoraInicio ;
   private String[] P006T3_A298DisponibilidadTipoCita ;
   private int[] P006T4_A20PacienteId ;
   private String[] P006T4_A217PacienteCorreo ;
   private String[] P006T4_A214PacienteTipoDocumento ;
   private int[] P006T5_A31ProfesionalId ;
   private String[] P006T5_A179ProfesionalCorreo ;
   private String[] P006T6_A54SedeTipoConsulta ;
   private short[] P006T6_A30SedeId ;
   private short[] P006T6_A32EspecialidadId ;
   private int[] P006T6_A31ProfesionalId ;
   private java.math.BigDecimal[] P006T6_A199CostoConsulta ;
}

final  class prcinformecitacorreo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006T2", "SELECT T1.[CitaId], T1.[CitaCode], T1.[CitaLink], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNombres], T2.[PacienteNroDocumento], T6.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T1.[PacienteId], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T1.[CitaMotivoConsulta], T4.[ProfesionalApellidoMaterno], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalNombres] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Especialidad] T6 ON T6.[EspecialidadId] = T3.[EspecialidadId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006T3", "SELECT [DisponibilidadId], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadTipoCita] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006T4", "SELECT [PacienteId], [PacienteCorreo], [PacienteTipoDocumento] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006T5", "SELECT [ProfesionalId], [ProfesionalCorreo] FROM [Profesional] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006T6", "SELECT [SedeTipoConsulta], [SedeId], [EspecialidadId], [ProfesionalId], [CostoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? and [EspecialidadId] = ? and [SedeId] = ? and [SedeTipoConsulta] = ? ORDER BY [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

