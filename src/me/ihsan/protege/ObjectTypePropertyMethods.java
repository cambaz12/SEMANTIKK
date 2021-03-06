/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.protege;


import java.io.File;
import org.semanticweb.owlapi.*;
import com.clarkparsia.pellet.owlapiv3.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static me.ihsan.protege.DataPropertyMethods.Ont_Base_IRI;
import static me.ihsan.protege.DataPropertyMethods.localLocation_IRI;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.NodeSet;
/**
 *
 * @author ihsanyigitbasi
 */
public class ObjectTypePropertyMethods {
    
    
    public static final File localLocation_IRI = new File("/Users/ihsanyigitbasi/Desktop/courses/semantinfinal/JFileChooserDemoydk1/FHR.owl");
    public static final IRI Ont_Base_IRI = IRI.create("http://ihsan.me/ontologies/finaldopplerexample");
    OWLOntologyManager m = OWLManager.createOWLOntologyManager();
    OWLDataFactory f = OWLManager.getOWLDataFactory();
    OWLOntology o = null;
    
    public void SAVEOTP(String indDomain, String OTP, String indRange) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));

            OWLNamedIndividual dom = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + indDomain));
            OWLNamedIndividual range = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + indRange));
            OWLObjectProperty oproperty = f.getOWLObjectProperty(IRI.create(Ont_Base_IRI + "#" + OTP));

            OWLObjectPropertyAssertionAxiom ax = f.getOWLObjectPropertyAssertionAxiom(oproperty, dom, range);
            if (o instanceof OWLMutableOntology) {
                if (!o.containsAxiom(ax)) {
                    AddAxiom addAx = new AddAxiom(o, ax);
                    m.applyChange(addAx);
                    m.saveOntology(o, new OWLXMLOntologyFormat(), IRI.create(localLocation_IRI));
                }
            }
            m.removeOntology(o);
        } catch (Exception e) {
            System.out.println("Could not create ontology: " + e.getMessage());
        }
    }
    
    public void removeOTP(String domindv, String oprop, String rangeindv) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual dom = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + domindv));
            OWLNamedIndividual range = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + rangeindv));
            OWLObjectProperty oproperty = f.getOWLObjectProperty(IRI.create(Ont_Base_IRI + "#" + oprop));
            OWLObjectPropertyAssertionAxiom ax = f.getOWLObjectPropertyAssertionAxiom(oproperty, dom, range);
            if (o instanceof OWLMutableOntology) {
                if (o.containsAxiom(ax)) {
                    RemoveAxiom rax = new RemoveAxiom(o, ax);
                    m.applyChange(rax);
                    m.saveOntology(o, new OWLXMLOntologyFormat(), IRI.create(localLocation_IRI));
                }
            }
            m.removeOntology(o);
        } catch (Exception e) {
            System.out.println("Could not create ontology: " + e.getMessage());
        }
    }
    
     /* public List getAnObjectProperty() {
        List<String> list = new ArrayList<String>();
        try {
            o = m.loadOntologyFromOntologyDocument(localLocation_IRI);
            PelletReasoner r = PelletReasonerFactory.getInstance().createReasoner(o);
            OWLNamedIndividual individual = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#00002"));
            OWLObjectProperty op = f.getOWLObjectProperty(IRI.create(Ont_Base_IRI + "#Next_Material"));
            NodeSet<OWLNamedIndividual> value = r.getObjectPropertyValues(individual, op);

            for (OWLNamedIndividual rangeVal : value.getFlattened()) {
                System.out.println(labelFor(individual, o) + "--> "
                        + labelFor(op, o) + "-->\n" + labelFor(rangeVal, o));

                // add to list

                list.add(labelFor(individual, o) + "--> "
                        + labelFor(op, o) + "-->" + labelFor(rangeVal, o).toString());
            }

            m.removeOntology(o);
        } catch (Exception e) {
            System.out.println("Could not create ontology: " + e.getMessage());
        }

        return list;
    } */
    public List getAnObjectProperty(String id, String OTP) {
        List<String> list = new ArrayList<String>();
        try {
            o = m.loadOntologyFromOntologyDocument(localLocation_IRI);

            PelletReasoner r = PelletReasonerFactory.getInstance().createReasoner(o);
            OWLNamedIndividual individual = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + id));
            OWLObjectProperty op = f.getOWLObjectProperty(IRI.create(Ont_Base_IRI + "#" + OTP));
            NodeSet<OWLNamedIndividual> set = r.getObjectPropertyValues(individual, op);

            for (OWLNamedIndividual each : set.getFlattened()) {
                String str = each.toString();
                String[] str1=null; 
                String newstring="";
                //str = StringRemoval(str); //Remove str IRI prefix
                if (str != null) {
                    str1=str.split("#");
                    newstring=str1[1].substring(0, str1[1].length()-1);
                    list.add(newstring);
                }
            }

            m.removeOntology(o);
        } catch (Exception e) {
            System.out.println("Could not create ontology: " + e.getMessage());
        }
        System.out.println(list);
        return list;
    }
     public String StringRemoval(String str) {
        str = str.substring(str.indexOf('#') + 1, str.length() - 1);
        return str;
    }
     
    public void removeClassAssertion(String clsnmae, String ind) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLClass cust = f.getOWLClass(IRI.create(Ont_Base_IRI + "#" + clsnmae));
            OWLNamedIndividual tc = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + ind));
            OWLClassAssertionAxiom ax = f.getOWLClassAssertionAxiom(cust, tc);
            // save in OWL/XML format
            if (o instanceof OWLMutableOntology) {
                if (o.containsAxiom(ax)) {
                    m.applyChange(new RemoveAxiom(o, ax));
                    m.saveOntology(o, new OWLXMLOntologyFormat(), IRI.create(localLocation_IRI));
                }
            }
            m.removeOntology(o);
        } catch (Exception e) {
            System.out.println("Could not create ontology: " + e.getMessage());
        }
    }
}
