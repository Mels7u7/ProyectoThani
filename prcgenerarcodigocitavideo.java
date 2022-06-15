package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgenerarcodigocitavideo extends GXProcedure
{
   public prcgenerarcodigocitavideo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgenerarcodigocitavideo.class ), "" );
   }

   public prcgenerarcodigocitavideo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      prcgenerarcodigocitavideo.this.aP1 = new String[] {""};
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
      prcgenerarcodigocitavideo.this.AV10Valor = aP0;
      prcgenerarcodigocitavideo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Codigo = httpContext.encrypt64( AV10Valor, com.genexus.util.Encryption.getNewKey( )) ;
      AV11CodigoFinal = GXutil.substring( AV9Codigo, 1, 20) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgenerarcodigocitavideo.this.AV11CodigoFinal;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11CodigoFinal = "" ;
      AV9Codigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10Valor ;
   private String AV11CodigoFinal ;
   private String AV9Codigo ;
   private String[] aP1 ;
}

