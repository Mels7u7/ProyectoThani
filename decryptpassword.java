package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class decryptpassword extends GXProcedure
{
   public decryptpassword( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( decryptpassword.class ), "" );
   }

   public decryptpassword( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      decryptpassword.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      decryptpassword.this.AV8SecUserPassword = aP0;
      decryptpassword.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9SecUserPasswordOut = httpContext.decrypt64( GXutil.substring( AV8SecUserPassword, 33, GXutil.len( AV8SecUserPassword)-32), GXutil.substring( AV8SecUserPassword, 1, 32)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = decryptpassword.this.AV9SecUserPasswordOut;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecUserPasswordOut = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SecUserPassword ;
   private String AV9SecUserPasswordOut ;
   private String[] aP1 ;
}

