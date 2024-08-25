import React, { useEffect, useState } from "react";
import { getCourseById } from "../services/courseService";
import { useParams } from "react-router-dom";

const CourseDetail = () => {
  const { id } = useParams();
  const [course, setCourse] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCourse = async () => {
      try {
        const response = await getCourseById(id);
        setCourse(response.data); // Set course data from API response
      } catch (error) {
        console.error("Error fetching course details:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchCourse();
  }, [id]);

  if (loading) return <p>Loading...</p>;
  if (!course) return <p>Course not found</p>;

  return (
    <div>
      <h1>{course.title}</h1>
      <p>{course.description}</p>
      <p>
        <strong>Code:</strong> {course.code}
      </p>
    </div>
  );
};

export default CourseDetail;
