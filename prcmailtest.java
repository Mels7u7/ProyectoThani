package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcmailtest extends GXProcedure
{
   public prcmailtest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcmailtest.class ), "" );
   }

   public prcmailtest( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17subject = "Alertas Thani Salud - Confirmación de cuenta" ;
      AV14MailRecipient.setAddress( "soportethani@gmail.com" );
      AV14MailRecipient.setName( "Alertas Thani Salud" );
      AV16SMTPSession.setHost( "smtp.gmail.com" );
      AV16SMTPSession.setUserName( "soportethani@gmail.com" );
      AV16SMTPSession.setPassword( "B*qe7o71mobR" );
      AV16SMTPSession.setPort( 22 );
      AV16SMTPSession.setSender( AV14MailRecipient );
      AV16SMTPSession.setAuthentication( (short)(1) );
      AV16SMTPSession.setSecure( (short)(1) );
      AV16SMTPSession.login();
      httpContext.GX_msglist.addItem("LogIn - Error Code:"+GXutil.str( AV16SMTPSession.getErrCode(), 10, 2));
      httpContext.GX_msglist.addItem("LogIn - Error Descripcion:"+AV16SMTPSession.getErrDescription());
      httpContext.GX_msglist.addItem("LogIn - ErrorDisplay:"+GXutil.str( AV16SMTPSession.getErrDisplay(), 10, 2));
      if ( GXutil.strcmp(AV16SMTPSession.getErrDescription(), "OK") == 0 )
      {
         AV12Log = (short)(1) ;
      }
      AV13MailMsg.getTo().addNew("Usuario: ", "cgonzaleslop@gmail.com") ;
      AV13MailMsg.setSubject( AV17subject );
      AV13MailMsg.setHtmltext( "Hola" );
      GXt_dtime1 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
      AV13MailMsg.setDateSent( GXt_dtime1 );
      AV16SMTPSession.send(AV13MailMsg);
      httpContext.GX_msglist.addItem("Send Mail - Error Code:"+GXutil.str( AV16SMTPSession.getErrCode(), 10, 2));
      httpContext.GX_msglist.addItem("Send Mail - Error Descripcion:"+AV16SMTPSession.getErrDescription());
      httpContext.GX_msglist.addItem("Send Mail - ErrorDisplay:"+GXutil.str( AV16SMTPSession.getErrDisplay(), 10, 2));
      AV16SMTPSession.logout();
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
      AV17subject = "" ;
      AV14MailRecipient = new com.genexus.internet.MailRecipient();
      AV16SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV13MailMsg = new com.genexus.internet.GXMailMessage();
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcmailtest__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12Log ;
   private short Gx_err ;
   private String AV17subject ;
   private java.util.Date GXt_dtime1 ;
   private com.genexus.internet.MailRecipient AV14MailRecipient ;
   private com.genexus.internet.GXMailMessage AV13MailMsg ;
   private com.genexus.internet.GXSMTPSession AV16SMTPSession ;
   private IDataStoreProvider pr_default ;
}

final  class prcmailtest__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

