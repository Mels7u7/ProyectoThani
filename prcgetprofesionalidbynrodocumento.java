package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetprofesionalidbynrodocumento extends GXProcedure
{
   public prcgetprofesionalidbynrodocumento( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetprofesionalidbynrodocumento.class ), "" );
   }

   public prcgetprofesionalidbynrodocumento( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( String aP0 )
   {
      prcgetprofesionalidbynrodocumento.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             int[] aP1 )
   {
      prcgetprofesionalidbynrodocumento.this.AV8ProfesionalNroDocumento = aP0;
      prcgetprofesionalidbynrodocumento.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006A2 */
      pr_default.execute(0, new Object[] {AV8ProfesionalNroDocumento});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A174ProfesionalNroDocumento = P006A2_A174ProfesionalNroDocumento[0] ;
         A31ProfesionalId = P006A2_A31ProfesionalId[0] ;
         AV9ProfesionalId = A31ProfesionalId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetprofesionalidbynrodocumento.this.AV9ProfesionalId;
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
      P006A2_A174ProfesionalNroDocumento = new String[] {""} ;
      P006A2_A31ProfesionalId = new int[1] ;
      A174ProfesionalNroDocumento = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetprofesionalidbynrodocumento__default(),
         new Object[] {
             new Object[] {
            P006A2_A174ProfesionalNroDocumento, P006A2_A31ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String AV8ProfesionalNroDocumento ;
   private String A174ProfesionalNroDocumento ;
   private int[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P006A2_A174ProfesionalNroDocumento ;
   private int[] P006A2_A31ProfesionalId ;
}

final  class prcgetprofesionalidbynrodocumento__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006A2", "SELECT [ProfesionalNroDocumento], [ProfesionalId] FROM [Profesional] WHERE RTRIM(LTRIM([ProfesionalNroDocumento])) = RTRIM(LTRIM(?)) ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
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

