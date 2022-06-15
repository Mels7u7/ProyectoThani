package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgenerarpasswordrandom extends GXProcedure
{
   public prcgenerarpasswordrandom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgenerarpasswordrandom.class ), "" );
   }

   public prcgenerarpasswordrandom( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      prcgenerarpasswordrandom.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      prcgenerarpasswordrandom.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8i = (short)(1) ;
      while ( AV8i <= 12 )
      {
         /* User Code */
          java.util.Random rand = new java.util.Random();
         /* User Code */
          int n = rand.nextInt(25);
         /* User Code */
          AV11ramdom = n;
         AV9letra = GXutil.chr( (short)(97+AV11ramdom)) ;
         AV10Password += AV9letra ;
         AV8i = (short)(AV8i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcgenerarpasswordrandom.this.AV10Password;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10Password = "" ;
      AV9letra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8i ;
   private short Gx_err ;
   private long AV11ramdom ;
   private String AV9letra ;
   private String AV10Password ;
   private String[] aP0 ;
}

