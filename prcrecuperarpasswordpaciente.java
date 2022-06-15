package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcrecuperarpasswordpaciente extends GXProcedure
{
   public prcrecuperarpasswordpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcrecuperarpasswordpaciente.class ), "" );
   }

   public prcrecuperarpasswordpaciente( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 )
   {
      prcrecuperarpasswordpaciente.this.aP2 = new boolean[] {false};
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
      prcrecuperarpasswordpaciente.this.AV20PacienteNroDocumento = aP0;
      prcrecuperarpasswordpaciente.this.AV17PacienteEmail = aP1;
      prcrecuperarpasswordpaciente.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005V2 */
      pr_default.execute(0, new Object[] {AV20PacienteNroDocumento, AV17PacienteEmail});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A217PacienteCorreo = P005V2_A217PacienteCorreo[0] ;
         A106PacienteNroDocumento = P005V2_A106PacienteNroDocumento[0] ;
         A20PacienteId = P005V2_A20PacienteId[0] ;
         A105PacienteNombres = P005V2_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P005V2_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = P005V2_A104PacienteApellidoMaterno[0] ;
         A6SecUserId = P005V2_A6SecUserId[0] ;
         n6SecUserId = P005V2_n6SecUserId[0] ;
         AV18PacienteId = A20PacienteId ;
         AV19PacienteNombres = A105PacienteNombres ;
         AV16PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         AV15PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         AV33PacienteCorreo = A217PacienteCorreo ;
         AV34PacienteUserId = A6SecUserId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18PacienteId > 0 )
      {
         AV23SecUser.Load((short)(AV34PacienteUserId));
         GXt_char1 = AV21PasswordRandom ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgenerarpasswordrandom(remoteHandle, context).execute( GXv_char2) ;
         prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV21PasswordRandom = GXt_char1 ;
         AV23SecUser.setgxTv_SdtSecUser_Secuserpassword( AV21PasswordRandom );
         AV23SecUser.Save();
         if ( AV23SecUser.Success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "prcrecuperarpasswordpaciente");
            AV22Resultado = true ;
            AV29subject = "Alertas Thani Salud - Envío de nueva contraseña" ;
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV13MailRecipient.setAddress( GXt_char1 );
            AV13MailRecipient.setName( "Alertas Thani Salud" );
            AV28SMTPSession.setHost( "mail.thanitech.pe" );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV28SMTPSession.setUserName( GXt_char1 );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV28SMTPSession.setPassword( GXt_char1 );
            AV28SMTPSession.setPort( 465 );
            AV28SMTPSession.setSender( AV13MailRecipient );
            AV28SMTPSession.setAuthentication( (short)(1) );
            AV28SMTPSession.setSecure( (short)(1) );
            AV28SMTPSession.login();
            if ( GXutil.strcmp(AV28SMTPSession.getErrDescription(), "OK") == 0 )
            {
               AV11Log = (short)(1) ;
            }
            AV12MailMsg.getTo().addNew("Usuario: ", AV33PacienteCorreo) ;
            AV12MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
            AV12MailMsg.setSubject( AV29subject );
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CorreoRecuperarContraseñaPaciente", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXt_char1 ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@PacienteNombreApellidos", ""+AV19PacienteNombres+" "+AV16PacienteApellidoPaterno+" "+AV15PacienteApellidoMaterno+"") ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@PacienteContraseña", AV23SecUser.getgxTv_SdtSecUser_Secuserpassword()) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
            GXt_char1 = AV30TemplateContent ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
            prcrecuperarpasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
            AV30TemplateContent = GXutil.strReplace( AV30TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
            AV12MailMsg.setHtmltext( AV30TemplateContent );
            GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
            AV12MailMsg.setDateSent( GXt_dtime3 );
            AV28SMTPSession.send(AV12MailMsg);
            AV28SMTPSession.logout();
         }
         else
         {
            AV22Resultado = false ;
            httpContext.GX_msglist.addItem("err");
            Application.rollbackDataStores(context, remoteHandle, pr_default, "prcrecuperarpasswordpaciente");
         }
      }
      else
      {
         AV22Resultado = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcrecuperarpasswordpaciente.this.AV22Resultado;
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
      P005V2_A217PacienteCorreo = new String[] {""} ;
      P005V2_A106PacienteNroDocumento = new String[] {""} ;
      P005V2_A20PacienteId = new int[1] ;
      P005V2_A105PacienteNombres = new String[] {""} ;
      P005V2_A103PacienteApellidoPaterno = new String[] {""} ;
      P005V2_A104PacienteApellidoMaterno = new String[] {""} ;
      P005V2_A6SecUserId = new short[1] ;
      P005V2_n6SecUserId = new boolean[] {false} ;
      A217PacienteCorreo = "" ;
      A106PacienteNroDocumento = "" ;
      A105PacienteNombres = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      AV19PacienteNombres = "" ;
      AV16PacienteApellidoPaterno = "" ;
      AV15PacienteApellidoMaterno = "" ;
      AV33PacienteCorreo = "" ;
      AV23SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV21PasswordRandom = "" ;
      AV29subject = "" ;
      AV13MailRecipient = new com.genexus.internet.MailRecipient();
      AV28SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV12MailMsg = new com.genexus.internet.GXMailMessage();
      AV30TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcrecuperarpasswordpaciente__default(),
         new Object[] {
             new Object[] {
            P005V2_A217PacienteCorreo, P005V2_A106PacienteNroDocumento, P005V2_A20PacienteId, P005V2_A105PacienteNombres, P005V2_A103PacienteApellidoPaterno, P005V2_A104PacienteApellidoMaterno, P005V2_A6SecUserId, P005V2_n6SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A6SecUserId ;
   private short AV11Log ;
   private short Gx_err ;
   private int A20PacienteId ;
   private int AV18PacienteId ;
   private int AV34PacienteUserId ;
   private String scmdbuf ;
   private String AV29subject ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date GXt_dtime3 ;
   private boolean AV22Resultado ;
   private boolean n6SecUserId ;
   private String AV30TemplateContent ;
   private String AV20PacienteNroDocumento ;
   private String AV17PacienteEmail ;
   private String A217PacienteCorreo ;
   private String A106PacienteNroDocumento ;
   private String A105PacienteNombres ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String AV19PacienteNombres ;
   private String AV16PacienteApellidoPaterno ;
   private String AV15PacienteApellidoMaterno ;
   private String AV33PacienteCorreo ;
   private String AV21PasswordRandom ;
   private com.genexus.internet.MailRecipient AV13MailRecipient ;
   private com.genexus.internet.GXMailMessage AV12MailMsg ;
   private com.genexus.internet.GXSMTPSession AV28SMTPSession ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P005V2_A217PacienteCorreo ;
   private String[] P005V2_A106PacienteNroDocumento ;
   private int[] P005V2_A20PacienteId ;
   private String[] P005V2_A105PacienteNombres ;
   private String[] P005V2_A103PacienteApellidoPaterno ;
   private String[] P005V2_A104PacienteApellidoMaterno ;
   private short[] P005V2_A6SecUserId ;
   private boolean[] P005V2_n6SecUserId ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV23SecUser ;
}

final  class prcrecuperarpasswordpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005V2", "SELECT [PacienteCorreo], [PacienteNroDocumento], [PacienteId], [PacienteNombres], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [SecUserId] FROM [Paciente] WHERE [PacienteNroDocumento] = RTRIM(LTRIM(?)) or [PacienteCorreo] = RTRIM(LTRIM(?)) ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
      }
   }

}

