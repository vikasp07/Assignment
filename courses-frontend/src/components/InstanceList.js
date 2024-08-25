import React, { useEffect, useState } from "react";
import { getInstances } from "../services/courseService";

const InstanceList = () => {
  const [instances, setInstances] = useState([]);

  useEffect(() => {
    const fetchInstances = async () => {
      try {
        const response = await getInstances();
        setInstances(response.data);
      } catch (error) {
        console.error("Error fetching instances:", error);
      }
    };

    fetchInstances();
  }, []);

  return (
    <div>
      <h1>Course Instances</h1>
      <ul>
        {instances.map((instance) => (
          <li key={instance.id}>
            {instance.course.title} - Year: {instance.year}, Semester:{" "}
            {instance.semester}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default InstanceList;
