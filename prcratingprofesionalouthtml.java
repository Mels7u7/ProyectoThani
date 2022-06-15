package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcratingprofesionalouthtml extends GXProcedure
{
   public prcratingprofesionalouthtml( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcratingprofesionalouthtml.class ), "" );
   }

   public prcratingprofesionalouthtml( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcratingprofesionalouthtml.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      prcratingprofesionalouthtml.this.AV9ProfesionalId = aP0;
      prcratingprofesionalouthtml.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005D3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9ProfesionalId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000GXC1 = P005D3_A40000GXC1[0] ;
         n40000GXC1 = P005D3_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
      }
      pr_default.close(0);
      GXv_int1[0] = (byte)(AV8Rating) ;
      new com.projectthani.prccalcularratingporprofesional(remoteHandle, context).execute( AV9ProfesionalId, GXv_int1) ;
      prcratingprofesionalouthtml.this.AV8Rating = GXv_int1[0] ;
      AV10RatingHtml += "<div class=\"rating\" style=\"margin-left:13px;margin-bottom:-5px;margin-top:-15px;\">" ;
      if ( AV8Rating == 0 )
      {
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
      }
      else if ( AV8Rating == 1 )
      {
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
      }
      else if ( AV8Rating == 2 )
      {
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
      }
      else if ( AV8Rating == 3 )
      {
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
      }
      else if ( AV8Rating == 4 )
      {
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star\"></i>" ;
      }
      else if ( AV8Rating == 5 )
      {
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
         AV10RatingHtml += "<i class=\"fas fa-star filled\"></i>" ;
      }
      AV11RatingNroRegistros = (short)(A40000GXC1) ;
      AV10RatingHtml += "<span class=\"d-inline-block average-rating\">(" + GXutil.str( AV11RatingNroRegistros, 4, 0) + ")</span>" ;
      AV10RatingHtml += "</div>" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcratingprofesionalouthtml.this.AV10RatingHtml;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10RatingHtml = "" ;
      scmdbuf = "" ;
      P005D3_A40000GXC1 = new int[1] ;
      P005D3_n40000GXC1 = new boolean[] {false} ;
      GXv_int1 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcratingprofesionalouthtml__default(),
         new Object[] {
             new Object[] {
            P005D3_A40000GXC1, P005D3_n40000GXC1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GXv_int1[] ;
   private short AV8Rating ;
   private short AV11RatingNroRegistros ;
   private short Gx_err ;
   private int AV9ProfesionalId ;
   private int A40000GXC1 ;
   private String scmdbuf ;
   private boolean n40000GXC1 ;
   private String AV10RatingHtml ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005D3_A40000GXC1 ;
   private boolean[] P005D3_n40000GXC1 ;
}

final  class prcratingprofesionalouthtml__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005D3", "SELECT COALESCE( T1.[GXC1], 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

