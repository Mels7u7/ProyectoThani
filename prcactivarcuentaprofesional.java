package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcactivarcuentaprofesional extends GXProcedure
{
   public prcactivarcuentaprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcactivarcuentaprofesional.class ), "" );
   }

   public prcactivarcuentaprofesional( int remoteHandle ,
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
      prcactivarcuentaprofesional.this.AV13ProfesionalId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007K3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13ProfesionalId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P007K3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P007K3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      AV12Profesional.Load(A40000ProfesionalId);
      AV8idProfesional = AV12Profesional.getgxTv_SdtProfesional_Profesionalid() ;
      if ( AV13ProfesionalId > 0 )
      {
         GXt_char1 = AV17UrlActivar ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "ThaniMainUrl", GXv_char2) ;
         prcactivarcuentaprofesional.this.GXt_char1 = GXv_char2[0] ;
         GXt_char3 = AV17UrlActivar ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.encriptpassword(remoteHandle, context).execute( "", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8idProfesional), 8, 0), GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV17UrlActivar = GXt_char1 + formatLink("com.projectthani.wpverificarcuentaprofesional", new String[] {GXutil.URLEncode(GXutil.rtrim(GXt_char3))}, new String[] {"VarProfesionalId"})  ;
         AV15subject = "Alertas Thani Salud - Confirmación de cuenta" ;
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV11MailRecipient.setAddress( GXt_char3 );
         AV11MailRecipient.setName( "Alertas Thani Salud" );
         AV14SMTPSession.setHost( "mail.thanitech.pe" );
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV14SMTPSession.setUserName( GXt_char3 );
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV14SMTPSession.setPassword( GXt_char3 );
         AV14SMTPSession.setPort( 465 );
         AV14SMTPSession.setSender( AV11MailRecipient );
         AV14SMTPSession.setAuthentication( (short)(1) );
         AV14SMTPSession.setSecure( (short)(1) );
         AV14SMTPSession.login();
         if ( GXutil.strcmp(AV14SMTPSession.getErrDescription(), "OK") == 0 )
         {
            AV9Log = (short)(1) ;
         }
         AV10MailMsg.getTo().addNew("Usuario: ", AV12Profesional.getgxTv_SdtProfesional_Profesionalcorreo()) ;
         AV10MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV10MailMsg.setSubject( AV15subject );
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CorreoVerificarCorreoProfesional", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXt_char3 ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@LogoThaniCabecera", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@LogoThaniFooter", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@ImagenFondoThani", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@ProfesionalNombresApellidos", ""+AV12Profesional.getgxTv_SdtProfesional_Profesionalnombres()+" "+AV12Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno()+" "+AV12Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno()+"") ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@ProfesionalUrlActivarCuenta", AV17UrlActivar) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@Youtube", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@Twitter", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@Facebook", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@Linkedin", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV16TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentaprofesional.this.GXt_char3 = GXv_char4[0] ;
         AV16TemplateContent = GXutil.strReplace( AV16TemplateContent, "@Instagram", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         AV10MailMsg.setHtmltext( AV16TemplateContent );
         GXt_dtime5 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV10MailMsg.setDateSent( GXt_dtime5 );
         AV14SMTPSession.send(AV10MailMsg);
         AV14SMTPSession.logout();
      }
      else
      {
         httpContext.GX_msglist.addItem("Error");
      }
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
      P007K3_A40000ProfesionalId = new int[1] ;
      P007K3_n40000ProfesionalId = new boolean[] {false} ;
      AV12Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV17UrlActivar = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV15subject = "" ;
      AV11MailRecipient = new com.genexus.internet.MailRecipient();
      AV14SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV10MailMsg = new com.genexus.internet.GXMailMessage();
      AV16TemplateContent = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      GXt_dtime5 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcactivarcuentaprofesional__default(),
         new Object[] {
             new Object[] {
            P007K3_A40000ProfesionalId, P007K3_n40000ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9Log ;
   private short Gx_err ;
   private int AV13ProfesionalId ;
   private int A40000ProfesionalId ;
   private int AV8idProfesional ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV15subject ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private java.util.Date GXt_dtime5 ;
   private boolean n40000ProfesionalId ;
   private String AV16TemplateContent ;
   private String AV17UrlActivar ;
   private com.genexus.internet.MailRecipient AV11MailRecipient ;
   private com.genexus.internet.GXMailMessage AV10MailMsg ;
   private com.genexus.internet.GXSMTPSession AV14SMTPSession ;
   private IDataStoreProvider pr_default ;
   private int[] P007K3_A40000ProfesionalId ;
   private boolean[] P007K3_n40000ProfesionalId ;
   private com.projectthani.SdtProfesional AV12Profesional ;
}

final  class prcactivarcuentaprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007K3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT [ProfesionalId] AS ProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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

