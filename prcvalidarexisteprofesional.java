package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidarexisteprofesional extends GXProcedure
{
   public prcvalidarexisteprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidarexisteprofesional.class ), "" );
   }

   public prcvalidarexisteprofesional( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      prcvalidarexisteprofesional.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      prcvalidarexisteprofesional.this.AV8ProfesionalNroDocumento = aP0;
      prcvalidarexisteprofesional.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002N3 */
      pr_default.execute(0, new Object[] {AV8ProfesionalNroDocumento});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P002N3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P002N3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      AV10ValId = A40000ProfesionalId ;
      if ( AV10ValId > 0 )
      {
         AV9Val = true ;
      }
      else
      {
         AV9Val = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcvalidarexisteprofesional.this.AV9Val;
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
      P002N3_A40000ProfesionalId = new int[1] ;
      P002N3_n40000ProfesionalId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidarexisteprofesional__default(),
         new Object[] {
             new Object[] {
            P002N3_A40000ProfesionalId, P002N3_n40000ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A40000ProfesionalId ;
   private int AV10ValId ;
   private String scmdbuf ;
   private boolean AV9Val ;
   private boolean n40000ProfesionalId ;
   private String AV8ProfesionalNroDocumento ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P002N3_A40000ProfesionalId ;
   private boolean[] P002N3_n40000ProfesionalId ;
}

final  class prcvalidarexisteprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002N3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
      }
   }

}

