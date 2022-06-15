package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcrecuperarpassworddoctor extends GXProcedure
{
   public prcrecuperarpassworddoctor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcrecuperarpassworddoctor.class ), "" );
   }

   public prcrecuperarpassworddoctor( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 )
   {
      prcrecuperarpassworddoctor.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      prcrecuperarpassworddoctor.this.AV32UsuarioDni = aP0;
      prcrecuperarpassworddoctor.this.AV31UsuarioCorreo = aP1;
      prcrecuperarpassworddoctor.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P008K2 */
      pr_default.execute(0, new Object[] {AV31UsuarioCorreo, AV31UsuarioCorreo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A179ProfesionalCorreo = P008K2_A179ProfesionalCorreo[0] ;
         A174ProfesionalNroDocumento = P008K2_A174ProfesionalNroDocumento[0] ;
         A31ProfesionalId = P008K2_A31ProfesionalId[0] ;
         A84ProfesionalNombres = P008K2_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P008K2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P008K2_A86ProfesionalApellidoMaterno[0] ;
         A6SecUserId = P008K2_A6SecUserId[0] ;
         AV18ProfesionalId = A31ProfesionalId ;
         AV19ProfesionalNombres = A84ProfesionalNombres ;
         AV16ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         AV15ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         AV17ProfesionalCorreo = A179ProfesionalCorreo ;
         AV34ProfesionalUserId = A6SecUserId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18ProfesionalId > 0 )
      {
         AV22SecUser.Load((short)(AV34ProfesionalUserId));
         GXt_char1 = AV14PasswordRandom ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgenerarpasswordrandom(remoteHandle, context).execute( GXv_char2) ;
         prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
         AV14PasswordRandom = GXt_char1 ;
         AV22SecUser.setgxTv_SdtSecUser_Secuserpassword( AV14PasswordRandom );
         AV22SecUser.Update();
         if ( AV22SecUser.Success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "prcrecuperarpassworddoctor");
            AV21Resultado = true ;
            AV28subject = "Alertas Thani Salud - Envío de nueva contraseña" ;
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV12MailRecipient.setAddress( GXt_char1 );
            AV12MailRecipient.setName( "Alertas Thani Salud" );
            AV27SMTPSession.setHost( "mail.thanitech.pe" );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV27SMTPSession.setUserName( GXt_char1 );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV27SMTPSession.setPassword( GXt_char1 );
            AV27SMTPSession.setPort( 465 );
            AV27SMTPSession.setSender( AV12MailRecipient );
            AV27SMTPSession.setAuthentication( (short)(1) );
            AV27SMTPSession.setSecure( (short)(1) );
            AV27SMTPSession.login();
            if ( GXutil.strcmp(AV27SMTPSession.getErrDescription(), "OK") == 0 )
            {
               AV10Log = (short)(1) ;
            }
            AV11MailMsg.getTo().addNew("Usuario: ", AV17ProfesionalCorreo) ;
            AV11MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
            AV11MailMsg.setSubject( AV28subject );
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CorreoRecuperarContraseñaPaciente", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXt_char1 ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@PacienteNombreApellidos", ""+AV19ProfesionalNombres+" "+AV16ProfesionalApellidoPaterno+" "+AV15ProfesionalApellidoMaterno+"") ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@PacienteContraseña", AV22SecUser.getgxTv_SdtSecUser_Secuserpassword()) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV29TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpassworddoctor.this.GXt_char1 = GXv_char2[0] ;
            AV29TemplateContent = GXutil.strReplace( AV29TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
            AV11MailMsg.setHtmltext( AV29TemplateContent );
            GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
            AV11MailMsg.setDateSent( GXt_dtime3 );
            AV27SMTPSession.send(AV11MailMsg);
            AV27SMTPSession.logout();
         }
         else
         {
            AV21Resultado = false ;
            Application.rollbackDataStores(context, remoteHandle, pr_default, "prcrecuperarpassworddoctor");
         }
      }
      else
      {
         AV21Resultado = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcrecuperarpassworddoctor.this.AV21Resultado;
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
      P008K2_A179ProfesionalCorreo = new String[] {""} ;
      P008K2_A174ProfesionalNroDocumento = new String[] {""} ;
      P008K2_A31ProfesionalId = new int[1] ;
      P008K2_A84ProfesionalNombres = new String[] {""} ;
      P008K2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P008K2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P008K2_A6SecUserId = new short[1] ;
      A179ProfesionalCorreo = "" ;
      A174ProfesionalNroDocumento = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      AV19ProfesionalNombres = "" ;
      AV16ProfesionalApellidoPaterno = "" ;
      AV15ProfesionalApellidoMaterno = "" ;
      AV17ProfesionalCorreo = "" ;
      AV22SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV14PasswordRandom = "" ;
      AV28subject = "" ;
      AV12MailRecipient = new com.genexus.internet.MailRecipient();
      AV27SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV11MailMsg = new com.genexus.internet.GXMailMessage();
      AV29TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcrecuperarpassworddoctor__default(),
         new Object[] {
             new Object[] {
            P008K2_A179ProfesionalCorreo, P008K2_A174ProfesionalNroDocumento, P008K2_A31ProfesionalId, P008K2_A84ProfesionalNombres, P008K2_A85ProfesionalApellidoPaterno, P008K2_A86ProfesionalApellidoMaterno, P008K2_A6SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A6SecUserId ;
   private short AV10Log ;
   private short Gx_err ;
   private int A31ProfesionalId ;
   private int AV18ProfesionalId ;
   private int AV34ProfesionalUserId ;
   private String scmdbuf ;
   private String AV28subject ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date GXt_dtime3 ;
   private boolean AV21Resultado ;
   private String AV29TemplateContent ;
   private String AV32UsuarioDni ;
   private String AV31UsuarioCorreo ;
   private String A179ProfesionalCorreo ;
   private String A174ProfesionalNroDocumento ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String AV19ProfesionalNombres ;
   private String AV16ProfesionalApellidoPaterno ;
   private String AV15ProfesionalApellidoMaterno ;
   private String AV17ProfesionalCorreo ;
   private String AV14PasswordRandom ;
   private com.genexus.internet.MailRecipient AV12MailRecipient ;
   private com.genexus.internet.GXMailMessage AV11MailMsg ;
   private com.genexus.internet.GXSMTPSession AV27SMTPSession ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P008K2_A179ProfesionalCorreo ;
   private String[] P008K2_A174ProfesionalNroDocumento ;
   private int[] P008K2_A31ProfesionalId ;
   private String[] P008K2_A84ProfesionalNombres ;
   private String[] P008K2_A85ProfesionalApellidoPaterno ;
   private String[] P008K2_A86ProfesionalApellidoMaterno ;
   private short[] P008K2_A6SecUserId ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV22SecUser ;
}

final  class prcrecuperarpassworddoctor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008K2", "SELECT [ProfesionalCorreo], [ProfesionalNroDocumento], [ProfesionalId], [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [SecUserId] FROM [Profesional] WHERE [ProfesionalNroDocumento] = RTRIM(LTRIM(?)) or [ProfesionalCorreo] = RTRIM(LTRIM(?)) ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
               stmt.setVarchar(1, (String)parms[0], 200);
               stmt.setVarchar(2, (String)parms[1], 200);
               return;
      }
   }

}

