import React, { useState } from "react";
import { createInstance } from "../services/courseService";
import { useNavigate } from "react-router-dom";

const InstanceForm = () => {
  const [year, setYear] = useState("");
  const [semester, setSemester] = useState("");
  const [courseId, setCourseId] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await createInstance({ year, semester, course: { id: courseId } });
      navigate("/instances");
    } catch (error) {
      console.error("Error creating instance:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h1>Add a New Course Instance</h1>
      <label>
        Year:
        <input
          type="number"
          value={year}
          onChange={(e) => setYear(e.target.value)}
          required
        />
      </label>
      <label>
        Semester:
        <input
          type="number"
          value={semester}
          onChange={(e) => setSemester(e.target.value)}
          required
        />
      </label>
      <label>
        Course ID:
        <input
          type="text"
          value={courseId}
          onChange={(e) => setCourseId(e.target.value)}
          required
        />
      </label>
      <button type="submit">Create</button>
    </form>
  );
};

export default InstanceForm;
