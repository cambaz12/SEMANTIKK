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
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.NodeSet;

public class DataPropertyMethods {
   public static final File localLocation_IRI = new File("/Users/ihsanyigitbasi/Desktop/courses/semantinfinal/JFileChooserDemoydk1/FHR.owl");
    public static final IRI Ont_Base_IRI = IRI.create("http://ihsan.me/ontologies/finaldopplerexample");
    OWLOntologyManager m = OWLManager.createOWLOntologyManager();
    OWLDataFactory f = OWLManager.getOWLDataFactory();
    OWLOntology o = null;
    
     public void saveClassAssertion(String clsnmae, String ind) {

        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));

            OWLClass cust = f.getOWLClass(IRI.create(Ont_Base_IRI + "#" + clsnmae));
            OWLNamedIndividual tc = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + ind));
            OWLClassAssertionAxiom ax = f.getOWLClassAssertionAxiom(cust, tc);
            // save in OWL/XML format
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

    

    public void SaveDTPInteger(String domindv, String dprop, int intdeger) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual domain = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + domindv));
            OWLDataProperty dproperty = f.getOWLDataProperty(IRI.create(Ont_Base_IRI + "#" + dprop));

            OWLDataPropertyAssertionAxiom ax = f.getOWLDataPropertyAssertionAxiom(dproperty, domain, intdeger);
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

    public void SaveDTPDouble(String domindv, String dprop, double doubledeger) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual domain = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + domindv));
            OWLDataProperty dproperty = f.getOWLDataProperty(IRI.create(Ont_Base_IRI + "#" + dprop));
            OWLDataPropertyAssertionAxiom ax = f.getOWLDataPropertyAssertionAxiom(dproperty, domain, doubledeger);
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

    public void SaveDTPString(String indDomain, String DTP, String str) {
        try {

            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual domain = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + indDomain));
            OWLDataProperty dproperty = f.getOWLDataProperty(IRI.create(Ont_Base_IRI + "#" + DTP));

            OWLDataPropertyAssertionAxiom ax = f.getOWLDataPropertyAssertionAxiom(dproperty, domain, str);
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

    

    public void removeDTPString(String domindv, String dprop, String strdeger) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual domain = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + domindv));
            OWLDataProperty dproperty = f.getOWLDataProperty(IRI.create(Ont_Base_IRI + "#" + dprop));
            OWLDataPropertyAssertionAxiom ax = f.getOWLDataPropertyAssertionAxiom(dproperty, domain, strdeger);
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

    public void removeDTPInteger(String domindv, String dprop, int intdeger) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual domain = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + domindv));
            OWLDataProperty dproperty = f.getOWLDataProperty(IRI.create(Ont_Base_IRI + "#" + dprop));
            OWLDataPropertyAssertionAxiom ax = f.getOWLDataPropertyAssertionAxiom(dproperty, domain, intdeger);
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

    public void removeDTPDouble(String domindv, String dprop, double doubledeger) {
        try {
            o = m.loadOntologyFromOntologyDocument(IRI.create(localLocation_IRI));
            OWLNamedIndividual domain = f.getOWLNamedIndividual(IRI.create(Ont_Base_IRI + "#" + domindv));
            OWLDataProperty dproperty = f.getOWLDataProperty(IRI.create(Ont_Base_IRI + "#" + dprop));
            OWLDataPropertyAssertionAxiom ax = f.getOWLDataPropertyAssertionAxiom(dproperty, domain, doubledeger);
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

   
    
}
