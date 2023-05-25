## Annotation in Java

Today is day 6 of the MacBook Contest by Telusko. 
Today's topic is Annotation in java

Learnings:
* Creation of Custom Annotations
  * How to create an Annotation
  * What is @Target annotation
  * What is @Retention annotation
  * Why they are used?
  * What are the different types of ElementType in <java.lang.annotation.ElementType>
  * What are the different types of RetentionPolicy
  * default keyword usage in annotation creation.
  * custom values declaration at the Annotation usage.
* Learnt about Override and FunctionalInterface
  * What are their RetentionPolicy and ElementType.

Annotations in Java are used to provide metadata or additional information 
about program elements such as classes, methods, fields, parameters, and
more. They offer a way to annotate and decorate code elements with markers,
labels, or instructions that can be processed at compile-time, runtime,
or by external tools.

Annotation works on the concept of Interface but both are different
To make a interface to Annotation
We use @ -> informs the compiler that it is not a interface but a Annotation type!
The other things which I want to mentions are
1. Target -> At which level you want to give the permission
Target have 12 enums(types):
     1.  ANNOTATION_TYPE        ->  Annotation interface declaration (Formerly known as an annotation type.)
     2.  CONSTRUCTOR            ->  Constructor declaration
     3.  FIELD                  ->  Field declaration (includes enum constants)
     4.  LOCAL_VARIABLE         ->  Local variable declaration
     5.  METHOD                 ->  Method declaration
     6.  MODULE                 ->  Module declaration.
     7.  PACKAGE                ->  Package declaration
     8.  PARAMETER              ->  Formal parameter declaration
     9.  RECORD_COMPONENT       ->  Record component
     10. TYPE                   ->  Class, interface (including annotation interface), enum, or record declaration
     11. TYPE_PARAMETER         ->  Type parameter declaration
     12. TYPE_USE               ->  Use of a type
2. Retention -> Upto which time(Compile time, Run time) it will work
RetentionPolicy have 3 type:
     1. CLASS                   -> Until the compile time
     2. SOURCE                  -> Act as a comment
     3. RUNTIME                 -> Act as a comment, reach to the compile time and also 
                    reaches runtime(Reaching JVM);

We have to two ways to declare the values in Annotation
1. Use default keyword in Annotation
2. Using explicit declaration of before the target level

We can declare multiple ElementType by making a list of them using {}.
Eg: {ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD}
This type of Target will work for all the 3 cases: class, constructor, fields
and Method

The code implementation in done in learningBuiltInAnnotation.java and 
learningCustomAnnotation.java