package fr.epsi.mspr;

import fr.epsi.mspr.agents.Agents;
import fr.epsi.mspr.materiel.Materiel;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        System.out.println("Beginning operations");
        String srcDir = "../EPSI_MSPR_1/";
        String outDir = "./output/";
        if(args.length>0 && args[0].length()>0){
            outDir = args[0];
        }
        if(args.length>1 && args[1].length()>0){
            srcDir = args[1];
        }

        Agents ap = new Agents(srcDir);
        ap.parseAgents();
        //ap.listAgents();
        try {
            Materiel materiel = new Materiel(srcDir);
            //materiel.printMateriel();
            ap.createAgentsPages(materiel,outDir);
            ap.createAgentsHtpasswdFile(outDir);
            System.out.println("End of operations");
        } catch (Exception e) {
            System.out.println("Couldn't parse the equipment");
        }

    }
}
