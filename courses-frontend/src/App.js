import React from "react";
import { Route, Routes } from "react-router-dom";
import CourseList from "./components/CourseList";
import CourseDetail from "./components/CourseDetail";
import CourseForm from "./components/CourseForm";
import InstanceList from "./components/InstanceList";
import InstanceDetail from "./components/InstanceDetail";
import InstanceForm from "./components/InstanceForm";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<CourseList />} />
      <Route path="/courses" element={<CourseList />} />
      <Route path="/courses/:id" element={<CourseDetail />} />
      <Route path="/courses/new" element={<CourseForm />} />
      <Route path="/instances" element={<InstanceList />} />
      <Route
        path="/instances/:year/:semester/:id"
        element={<InstanceDetail />}
      />
      <Route path="/instances/new" element={<InstanceForm />} />
    </Routes>
  );
};

export default App;
